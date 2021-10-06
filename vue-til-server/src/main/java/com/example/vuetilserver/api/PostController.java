package com.example.vuetilserver.api;

import com.example.vuetilserver.domain.Post;
import com.example.vuetilserver.dto.PostDto;
import com.example.vuetilserver.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public PostDto.Insert insertPost(@RequestBody PostDto.PostInsert postInsert){

        return postService.insertPost(postInsert);
    }

    @PutMapping("/delete/{postId}")
    public PostDto.Delete deletePost(@PathVariable(name = "postId") Optional<Long> postId){
        System.out.println(postId);

        return postService.deletePost(postId.get());
    }

    @GetMapping("/info")
    public PostDto.info infoPost(@ModelAttribute PostDto.infoParam infoParam){
        return postService.info(infoParam);
    }
}
