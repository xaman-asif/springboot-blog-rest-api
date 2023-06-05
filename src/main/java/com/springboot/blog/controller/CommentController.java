package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDTO;
import com.springboot.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(@PathVariable(value = "postId") long postId,@Valid @RequestBody CommentDTO commentDTO) {
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

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable(value = "postId") long postId, @PathVariable(value = "commentId") long commentId,@Valid @RequestBody CommentDTO commentDTO) {
        CommentDTO responseCommentDTO = commentService.updateComment(postId, commentId, commentDTO);

        return new ResponseEntity<>(responseCommentDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") long postId, @PathVariable(value = "commentId") long commentId) {
        String response = commentService.deleteComment(postId, commentId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
