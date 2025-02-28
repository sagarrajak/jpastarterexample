package com.jpastarterexample.in21mincourse.jpastarterexample.entity.customcurrency;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Currency implements Serializable {
    protected final BigDecimal value;
    protected final String currency;

    public Currency(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency1 = (Currency) o;
        return Objects.equals(value, currency1.value) && Objects.equals(currency, currency1.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public String toString() {
        return value.toString()+" "+currency;
    }

    public static Currency fromString(String s) {
        String[] s1 = s.split(" ");
        return new Currency(new BigDecimal(s1[0]), s1[1].toUpperCase());
    }
}
