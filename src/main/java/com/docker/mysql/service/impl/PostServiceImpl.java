package com.docker.mysql.service.impl;

import com.docker.mysql.dto.request.PostRequestDto;
import com.docker.mysql.entity.Post;
import com.docker.mysql.repository.PostRepository;
import com.docker.mysql.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {
    private final PostRepository postRepository;

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(PostRequestDto postRequestDto) {
        Post newPost = Post.builder()
                .title(postRequestDto.getTitle())
                .build();
        return postRepository.save(newPost);
    }
}
