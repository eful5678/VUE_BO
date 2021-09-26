package com.example.vuetilserver.service;

import com.example.vuetilserver.dto.PostDto;
import com.example.vuetilserver.repository.PostRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepositorySupport postRepositorySupport;

    @Override
    public List<PostDto.PostList> search() {
        return postRepositorySupport.search();
    }

}
