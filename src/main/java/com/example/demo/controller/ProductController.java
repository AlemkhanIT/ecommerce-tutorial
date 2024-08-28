package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductListDTO;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDTO> createProduct(@RequestPart("product") @Valid ProductDTO productDTO,
                                                    @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {
        return ResponseEntity.ok(productService.createProduct(productDTO, image));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id,
                                                    @RequestPart("product") @Valid ProductDTO productDTO,
                                                    @RequestPart(value = "image", required = false) MultipartFile image)throws IOException{
        return ResponseEntity.ok(productService.updateProduct(id, productDTO, image));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProduct(id));
    }
    @GetMapping
    public ResponseEntity<Page<ProductListDTO>> getAllProducts(@PageableDefault(size=10) Pageable pageable){
        return ResponseEntity.ok(productService.getAllProducts(pageable));
    }
}
