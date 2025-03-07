package com.jpastarterexample.in21mincourse.jpastarterexample.dto.mapper;

import com.jpastarterexample.in21mincourse.jpastarterexample.dto.CreateProductDto;
import com.jpastarterexample.in21mincourse.jpastarterexample.entity.products.Bids;
import com.jpastarterexample.in21mincourse.jpastarterexample.entity.products.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductBidMapper {
    @Mapping(target = "amount", source = "createProductDto.amount")
    @Mapping(target = "description", source = "createProductDto.description")
    Bids map(CreateProductDto createProductDto);
}
