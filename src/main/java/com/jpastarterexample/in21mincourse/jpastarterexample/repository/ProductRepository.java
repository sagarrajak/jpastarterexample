package com.jpastarterexample.in21mincourse.jpastarterexample.repository;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
}
