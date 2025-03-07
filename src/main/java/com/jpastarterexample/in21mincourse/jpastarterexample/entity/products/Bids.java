package com.jpastarterexample.in21mincourse.jpastarterexample.entity.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "bids")
@Data
@org.hibernate.annotations.Immutable
public class Bids {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Double amount;

    String description;

    @org.hibernate.annotations.CreationTimestamp
    LocalDateTime createdDate;

    @org.hibernate.annotations.UpdateTimestamp
    LocalDateTime updatedDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    Product product;
}
