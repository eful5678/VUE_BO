package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Post;
import com.example.vuetilserver.dto.PostDto;

import java.util.List;

public interface PostRepositorySupport {

    List<PostDto.PostList> search();

    Post findPostById(Long postId);
}
