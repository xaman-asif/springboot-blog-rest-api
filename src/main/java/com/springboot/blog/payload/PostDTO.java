package com.springboot.blog.payload;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class PostDTO {
    private Long id;

    private String title;

    private String description;

    private String content;

    private Set<CommentDTO> comments;
}
