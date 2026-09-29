package com.project.bookstore.domain.model;

import java.time.LocalDateTime;

public class Customer {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String shippingAddress;
    private LocalDateTime createdAt;
}
