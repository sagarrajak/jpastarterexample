package com.jpastarterexample.in21mincourse.jpastarterexample.entity.customcurrency;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CurrencyConverter implements AttributeConverter<Currency, String> {
    @Override
    public String convertToDatabaseColumn(Currency attribute) {
        return attribute.toString();
    }

    @Override
    public Currency convertToEntityAttribute(String dbData) {
        return Currency.fromString(dbData);
    }
}
