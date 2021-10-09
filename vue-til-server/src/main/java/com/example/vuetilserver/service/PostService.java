package com.example.vuetilserver.service;

import com.example.vuetilserver.domain.Post;
import com.example.vuetilserver.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto.PostList> search();

    PostDto.Insert insertPost(PostDto.PostInsert postInsert);

    PostDto.Delete deletePost(Long postId);

    PostDto.info info(PostDto.infoParam infoParam);

    PostDto.update updatePost(PostDto.updateParam updateParam);
}
