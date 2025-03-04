package com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.tableperclass;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AttributeOverride(name = "owner", column = @Column(name = "bank_owner", nullable = false))
public class BankAccount extends BillingDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String accountNumber;
    String bankName;
    String ifscCode;
    String bankCode;
}
