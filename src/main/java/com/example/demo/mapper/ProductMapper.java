package com.example.demo.mapper;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Comment;
import com.example.demo.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface ProductMapper {
    ProductDTO toDTO(Product product);

    Product toEntity(ProductDTO productDTO);

    CommentDTO toDTO(Comment comment);

    Comment toEntity(CommentDTO commentDTO);
}
