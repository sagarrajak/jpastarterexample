package com.jpastarterexample.in21mincourse.jpastarterexample.entity.inheritance.emdebbed;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "weight_name")),
        @AttributeOverride(name = "symbol", column = @Column(name = "weight_symbol")),
})
@Data
public class Weight extends Mesurement{
    @NotNull
    protected BigDecimal weight;
}
