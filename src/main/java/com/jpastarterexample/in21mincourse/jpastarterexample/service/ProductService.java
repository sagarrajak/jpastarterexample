package com.jpastarterexample.in21mincourse.jpastarterexample.service;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {
    private final EntityManager em;

    public ProductService(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Transactional
    public void createProduct() {
        Product item = new Product();
        item.setName("sagar");
        log.info("Creatting product {}", item.getName());
        this.em.persist(item);
    }
}
