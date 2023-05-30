package com.springboot.blog.service;

import com.springboot.blog.payload.PostDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    List<PostDTO> getAllPosts();
}
