package com.springboot.blog.controller;

import com.springboot.blog.payload.DTOs.PostDTO;
import com.springboot.blog.payload.PostResponse;
import com.springboot.blog.service.PostService;
import com.springboot.blog.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {

        PostDTO postDTO = postService.getPostById(id);

        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "orderBy", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String orderBy
    ) {
        return new ResponseEntity<>(postService.getAllPosts(pageNo, pageSize, sortBy, orderBy), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDTO) {
        postDTO.setId(0L);
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long id,@Valid @RequestBody PostDTO postDTO) {

        return new ResponseEntity<>(postService.updatePost(id, postDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/search/{query}")
    public ResponseEntity<PostResponse> searchPosts(@PathVariable String query,
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "orderBy", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String orderBy
    ) {
        return new ResponseEntity<>(postService.searchPosts(query, pageNo, pageSize, sortBy, orderBy), HttpStatus.OK);
    }

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadMedia(@RequestParam("fileName") MultipartFile multipartFile) {
//        File file = new File(multipartFile.getOriginalFilename());
//
//        try (OutputStream os = new FileOutputStream(file)) {
//            os.write(multipartFile.getBytes());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

}
