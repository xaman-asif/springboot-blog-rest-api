package com.springboot.blog.payload;

import com.springboot.blog.entity.Order;
import com.springboot.blog.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Order order;
    private Payment payment;
}
