package com.example.vuetilserver.service;

import com.example.vuetilserver.domain.Member;
import com.example.vuetilserver.domain.Post;
import com.example.vuetilserver.dto.PostDto;
import com.example.vuetilserver.repository.MemberRepositorySupport;
import com.example.vuetilserver.repository.PostRepositoryManager;
import com.example.vuetilserver.repository.PostRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepositorySupport postRepositorySupport;
    private final PostRepositoryManager postRepositoryManager;

    private final MemberRepositorySupport memberRepositorySupport;

    @Override
    public List<PostDto.PostList> search() {
        return postRepositorySupport.search();
    }

    @Override
    public PostDto.Insert insertPost(PostDto.PostInsert postInsert) {
        
        final Member member = memberRepositorySupport.findMemberByUsername(postInsert.getUsername());
        
        if(member.getUsername() == null){
            System.out.println("로그인");
        }else{
            final Post post = postRepositoryManager.insertPost(postInsert);

            return new PostDto.Insert().lazyModeling(post);

        }

        return null;
    }

    @Override
    public PostDto.Delete deletePost(Long postId) {

        final Post post = postRepositorySupport.findPostById(postId);

        postRepositoryManager.deletePost(post);

        return new PostDto.Delete().lazyModeling(post);
    }

    @Override
    public PostDto.info info(PostDto.infoParam infoParam) {

        final Post post = postRepositorySupport.findPostById(infoParam.getPostId());

        return new PostDto.info().lazyModeling(post);
    }

}
