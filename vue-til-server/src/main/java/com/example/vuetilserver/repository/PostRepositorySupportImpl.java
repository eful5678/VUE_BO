package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.domain.Post;
import com.example.vuetilserver.domain.QMember;
import com.example.vuetilserver.domain.QPost;
import com.example.vuetilserver.dto.PostDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PostRepositorySupportImpl extends QuerydslRepositorySupport implements PostRepositorySupport{

    private final JPAQueryFactory jpaQueryFactory;

    public PostRepositorySupportImpl(EntityManager em){
        super(Post.class);
        super.setEntityManager(em);
        jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<PostDto.PostList> search() {

        final QPost post = QPost.post;
        final QMember member = QMember.member;

        return jpaQueryFactory.select(Projections.constructor(PostDto.PostList.class, post, member))
                                .from(post)
                                .join(member)
                                .on(post.member.id.eq(member.id))
                                .fetch();
    }
}
