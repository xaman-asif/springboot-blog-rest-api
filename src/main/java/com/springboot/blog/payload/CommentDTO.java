package com.springboot.blog.payload;

import com.springboot.blog.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommentDTO {
    private Long id;

    private String name;
    private String email;
    private String body;

//    private Post post;
}
