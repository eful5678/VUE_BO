package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Post;
import com.example.vuetilserver.dto.PostDto;

public interface PostRepositoryManager {

    Post insertPost(PostDto.PostInsert postInsert);
}
