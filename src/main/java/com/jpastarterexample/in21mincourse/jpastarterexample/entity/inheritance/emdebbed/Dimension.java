package com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.emdebbed;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "dimension_name")),
        @AttributeOverride(name = "symbol", column = @Column(name = "symbol_name"))
})
public class Dimension extends Mesurement{
    protected BigDecimal width;
    protected BigDecimal height;
    protected BigDecimal depth;
}
