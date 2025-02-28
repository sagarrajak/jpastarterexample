package com.jpastarterexample.in21mincourse.jpastarterexample.entity;

import com.jpastarterexample.in21mincourse.jpastarterexample.entity.customcurrency.Currency;
import jakarta.persistence.*;
import lombok.Data;

@Entity()
@Data
@Table(name = "product_items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "current_price")
    Currency currentPrice;
}
