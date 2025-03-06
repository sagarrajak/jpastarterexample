package com.jpastarterexample.in21mincourse.jpastarterexample.controller;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.Product;
import com.jpastarterexample.in21mincourse.jpastarterexample.service.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController()
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("search")
    public ResponseEntity<Page<Product>> findAll(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "minPrice", required = false) Double minPrice,
            @RequestParam(value = "maxPrice", required = false) Double maxPrice,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "page", defaultValue = "0") int page, // Default page number is 0
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getProducts(name, minPrice, maxPrice, category, pageRequest));
    }
}
