package com.project.bookstore.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private Customer customer;
    private LocalDateTime orderDate;
    private String status;
    private List<OrderItem> detailItem;
    private Double totalToPay;
}
