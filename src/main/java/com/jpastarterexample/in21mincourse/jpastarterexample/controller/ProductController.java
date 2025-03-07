package com.jpastarterexample.in21mincourse.jpastarterexample.controller;

import com.jpastarterexample.in21mincourse.jpastarterexample.dto.CreateProductDto;
import com.jpastarterexample.in21mincourse.jpastarterexample.entity.products.Bids;
import com.jpastarterexample.in21mincourse.jpastarterexample.entity.products.Product;
import com.jpastarterexample.in21mincourse.jpastarterexample.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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

    @GetMapping("category")
    public ResponseEntity<Page<String>> getAllCategory(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "page", defaultValue = "0") int page, // Default page number is 0
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getAllCategories(pageRequest));
    }

    @PostMapping()
    public ResponseEntity addProduct(
            @Valid @RequestBody CreateProductDto createProductDto
    ) {
        Bids bids = productService.addBidToProduct(createProductDto);
        URI uri = URI.create("/bids/" + bids.getId());
        return ResponseEntity.created(uri).build();
    }
}
