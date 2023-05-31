package com.springboot.blog.service;

import com.springboot.blog.payload.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    List<PostDTO> getAllPosts();

    PostDTO getPostById(Long id);

    PostDTO updatePost(Long id, PostDTO updatedPostDTO);

    void deletePost(Long id);
}
