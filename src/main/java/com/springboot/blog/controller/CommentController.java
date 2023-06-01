package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDTO;
import com.springboot.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(@PathVariable(value = "postId") long postId, @RequestBody CommentDTO commentDTO) {
        CommentDTO responseCommentDTO = commentService.createComment(postId, commentDTO);

        return new ResponseEntity<>(responseCommentDTO, HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentDTO>> getCommentsByPostId(@PathVariable(value = "postId") long postId) {

        List<CommentDTO> responseCommentDTO = commentService.getCommentsByPostId(postId);
        return new ResponseEntity<>(responseCommentDTO, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable(value = "postId") long postId, @PathVariable(value = "commentId") long commentId) {
        CommentDTO responseCommentDTO = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(responseCommentDTO, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable(value = "postId") long postId, @PathVariable(value = "commentId") long commentId, @RequestBody CommentDTO commentDTO) {
        CommentDTO responseCommentDTO = commentService.updateComment(postId, commentId, commentDTO);

        return new ResponseEntity<>(responseCommentDTO, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") long postId, @PathVariable(value = "commentId") long commentId) {
        String response = commentService.deleteComment(postId, commentId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
