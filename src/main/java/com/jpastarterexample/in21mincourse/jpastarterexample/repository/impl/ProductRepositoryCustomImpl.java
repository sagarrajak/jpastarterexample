package com.jpastarterexample.in21mincourse.jpastarterexample.repository.impl;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.products.Product;
import com.jpastarterexample.in21mincourse.jpastarterexample.repository.ProductRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    private final EntityManager em;


    @Override
    public Page<Product> findByCategory(String name, Double minPrice, Double maxPrice, String category, Pageable pageable) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> product = query.from(Product.class);
//        product.fetch("bids", JoinType.LEFT);
        List<Predicate> predicates = getPredicates(name, minPrice, maxPrice, category, cb, product);
        query.select(product).where(predicates.toArray(new Predicate[0])).orderBy(cb.asc(product.get("name")));
        List<Product> resultList = em.createQuery(query)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();


        // count query builder
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Product> countProductRoot = countQuery.from(Product.class);
        List<Predicate> predicates2 = getPredicates(name, minPrice, maxPrice, category, cb, countProductRoot);

        countQuery.select(cb.count(countProductRoot))
                .where(predicates2.toArray(new Predicate[0]));

        Long singleResult = em.createQuery(countQuery).getSingleResult();


        return new PageImpl<>(resultList, pageable, singleResult);
    }

    @Override
    public Page<String> findAllCategory(Pageable pageable) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<String> query = cb.createQuery(String.class);
        Root<Product> productRoot = query.from(Product.class);
        query.select(productRoot.get("category")).distinct(true);

        List<String> resultList = em.createQuery(query)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Product> countProductRoot = countQuery.from(Product.class);
        countQuery.select(cb.countDistinct(countProductRoot.get("category")));
        Long singleResult = em.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(resultList, pageable, singleResult);
    }

    private static List<Predicate> getPredicates(
            String name,
            Double minPrice,
            Double maxPrice,
            String category,
            CriteriaBuilder cb,
            Root<Product> countProductRoot
    ) {
        List<Predicate> predicates2 = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            predicates2.add(cb.like(countProductRoot.get("name"),"%" + name + "%"  ));
        }
        if (minPrice != null && minPrice > 0) {
            predicates2.add(cb.lessThanOrEqualTo(countProductRoot.get("price"), minPrice));
        }
        if (maxPrice != null && maxPrice > 0) {
            predicates2.add(cb.greaterThanOrEqualTo(countProductRoot.get("price"), maxPrice));
        }
        if (category != null && !category.isEmpty()) {
            predicates2.add(cb.equal(countProductRoot.get("category"), category));
        }
        return predicates2;
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        Product product = em.createQuery("select p from Product p where p.id = :id", Product.class)
                .setParameter("id", id)
                .getResultList()
                .get(0);
        return Optional.of(product);
    }
}
