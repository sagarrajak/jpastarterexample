package com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.emdebbed;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;


@MappedSuperclass
public abstract class Mesurement {
    @NotNull
    protected String name;
    @NotNull
    protected String symbol;
}
