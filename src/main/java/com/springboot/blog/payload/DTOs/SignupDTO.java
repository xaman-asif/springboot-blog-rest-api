package com.springboot.blog.payload.DTOs;

import lombok.Data;

@Data
public class SignupDTO {
    private String name;
    private String username;
    private String email;
    private String password;
}
