package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDTO {
    private Long id;
    private Long usedId;
    private List<CartItemDTO> items;
}
