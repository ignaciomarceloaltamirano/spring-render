package com.docker.mysql.controller;

import com.docker.mysql.dto.request.PostRequestDto;
import com.docker.mysql.entity.Post;
import com.docker.mysql.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final IPostService postService;

    @GetMapping
    public List<Post>getPosts(){
        return postService.getPosts();
    }

    @PostMapping
    public Post createPost(@RequestBody PostRequestDto postRequestDto){
        return postService.createPost(postRequestDto);
    }
}
