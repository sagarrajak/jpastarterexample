package com.jpastarterexample.in21mincourse.jpastarterexample.repository;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductRepositoryCustom {
    Page<Product> findByCategory(String name,
                                 Double minPrice,
                                 Double maxPrice,
                                 String category,
                                 Pageable pageable);
}
