package com.springboot.blog.payload.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorDetailsDTO {

    private Date Timestamp;
    private String message;
    private String details;
}
