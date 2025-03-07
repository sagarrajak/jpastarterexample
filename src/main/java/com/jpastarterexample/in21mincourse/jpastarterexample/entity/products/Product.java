package com.jpastarterexample.in21mincourse.jpastarterexample.entity.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
    @SequenceGenerator(name = "products_seq", sequenceName = "products_seq") // JPQ Sequence
    Long id;

    String name;

    Double price;

    String category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    List<Bids> bids = new ArrayList<>();
}
