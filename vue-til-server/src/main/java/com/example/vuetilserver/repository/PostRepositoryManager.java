package com.example.vuetilserver.repository;

import com.example.vuetilserver.dto.PostDto;

public interface PostRepositoryManager {

    void insertPost(PostDto.PostInsert postInsert);
}
