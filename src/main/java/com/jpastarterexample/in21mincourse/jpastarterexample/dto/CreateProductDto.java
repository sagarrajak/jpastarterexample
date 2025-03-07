package com.jpastarterexample.in21mincourse.jpastarterexample.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductDto {
    @NotNull
    @Min(value = 1,message = "Amount can't be less then 1")
    private Double amount;
    private String description;

    @NotNull(message = "product id can't be null")
    @Min(value = 1)
    @JsonProperty("product_id")
    private Long productId;
}
