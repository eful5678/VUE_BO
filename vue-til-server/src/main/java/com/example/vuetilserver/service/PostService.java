package com.example.vuetilserver.service;

import com.example.vuetilserver.domain.Post;
import com.example.vuetilserver.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto.PostList> search();

    void insertPost(PostDto.PostInsert postInsert);
}
