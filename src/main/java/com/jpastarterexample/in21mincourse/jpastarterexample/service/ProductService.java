package com.jpastarterexample.in21mincourse.jpastarterexample.service;

import com.jpastarterexample.in21mincourse.jpastarterexample.dto.CreateProductDto;
import com.jpastarterexample.in21mincourse.jpastarterexample.dto.mapper.ProductBidMapper;
import com.jpastarterexample.in21mincourse.jpastarterexample.entity.products.Bids;
import com.jpastarterexample.in21mincourse.jpastarterexample.entity.products.Product;
import com.jpastarterexample.in21mincourse.jpastarterexample.repository.BidsRepository;
import com.jpastarterexample.in21mincourse.jpastarterexample.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final EntityManager em;
    private final ProductRepository productRepository;
    private final BidsRepository bidsRepository;
    private final ProductBidMapper productBidMapper;

    @Transactional
    public void createProduct() {
        Product item = new Product();
        item.setName("sagar");
        log.info("Creatting product {}", item.getName());
        this.em.persist(item);
    }

    public Page<Product> getProducts(String name, Double minPrice, Double maxPrice, String category, Pageable pageable) {
        return productRepository.findByCategory(name, minPrice, maxPrice, category, pageable);
    }

    public Page<String> getAllCategories(Pageable pageable) {
        return productRepository.findAllCategory(pageable);
    }

    @Transactional
    public Bids addBidToProduct(CreateProductDto createProductDto) {
        Product product = productRepository
                .findById(createProductDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Bids bid = productBidMapper.map(createProductDto);
        bid.setProduct(product);
        em.persist(bid);
        return bid;
    }
}
