package com.docker.mysql.service;

import com.docker.mysql.dto.request.PostRequestDto;
import com.docker.mysql.entity.Post;

import java.util.List;

public interface IPostService {
    List<Post> getPosts();
    Post createPost(PostRequestDto postRequestDto);
}
