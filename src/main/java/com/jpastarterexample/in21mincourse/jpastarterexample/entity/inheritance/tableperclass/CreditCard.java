package com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.tableperclass;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "credit_card")
@Data
@AttributeOverride(name = "owner", column = @Column(name = "cc_owner", nullable = false))
public class CreditCard extends BillingDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true, nullable = false)
    String number;
    @Column(nullable = false)
    Integer expMonth;
    @Column(nullable = false)
    Integer expYear;
}
