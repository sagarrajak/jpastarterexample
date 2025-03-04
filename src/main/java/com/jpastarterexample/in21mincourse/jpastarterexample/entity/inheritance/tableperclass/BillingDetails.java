package com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.tableperclass;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BillingDetails {
    @Column(name = "owner", nullable = false)
    private String owner;
}
