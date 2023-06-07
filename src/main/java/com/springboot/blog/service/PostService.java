package com.springboot.blog.service;

import com.springboot.blog.payload.DTOs.PostDTO;
import com.springboot.blog.payload.PostResponse;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String orderBy);

    PostDTO getPostById(Long id);

    PostDTO updatePost(Long id, PostDTO updatedPostDTO);

    void deletePostById(Long id);
}
