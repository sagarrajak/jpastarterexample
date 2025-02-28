package com.jpastarterexample.in21mincourse.jpastarterexample;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
    @Column(nullable = false)
    protected String street1;

    protected String street2;

    protected String city;

    @Column(length = 10)
    protected String zipcode;
}
