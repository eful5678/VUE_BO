package com.example.vuetilserver.repository;

import com.example.vuetilserver.config.SessionUtil;
import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.domain.Post;
import com.example.vuetilserver.dto.PostDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.manager.util.SessionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class PostRepositoryManagerImpl implements PostRepositoryManager{

    private final EntityManager em;

    private final MemberRepositorySupport memberRepositorySupport;
    private final PostRepositorySupport postRepositorySupport;

    @Override
    public Post insertPost(PostDto.PostInsert postInsert) {
//        Long id = SessionUtil.getUsername();
//        final Member member = memberRepositorySupport.findMemberById(SessionUtil.getUsername());

        final Member member = memberRepositorySupport.findMemberByUsername(postInsert.getUsername());
        final Post post = postInsert.toEntity(member).get();

        em.persist(post);

        return post;

    }

    @Override
    public void deletePost(Post post) {

        post.doRemove(post);

    }

    @Override
    public void updatePost(PostDto.updateParam updateParam) {
        final Post post = postRepositorySupport.findPostById(updateParam.getPostId());
        post.setTitle(updateParam.getTitle());
        post.setContents(updateParam.getContents());
        post.doChange(post);
    }
}
