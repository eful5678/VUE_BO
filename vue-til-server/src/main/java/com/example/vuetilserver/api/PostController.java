package com.example.vuetilserver.api;

import com.example.vuetilserver.domain.Post;
import com.example.vuetilserver.dto.PostDto;
import com.example.vuetilserver.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:8080")
public class PostController {

    private final PostService postService;

    @GetMapping("/search")
    public List<PostDto.PostList> searchPosts(){
        return postService.search();
    }

    @PostMapping("/insert")
    public void insertPost(@RequestBody PostDto.PostInsert postInsert){
        postService.insertPost(postInsert);
    }
}
