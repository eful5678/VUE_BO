package com.example.vuetilserver.service;

import com.example.vuetilserver.domain.Member;
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
    public void insertPost(PostDto.PostInsert postInsert) {
        
        final Member member = memberRepositorySupport.findMemberByUsername(postInsert.getUsername());
        
        if(member.getUsername() == null){
            System.out.println("로그인");
        }else{
            postRepositoryManager.insertPost(postInsert);
        }

        
    }

}
