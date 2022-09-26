package com.zero.mealkitservice.dto;

import com.zero.mealkitservice.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;

    public static ProductDto fromEntity(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .build();
    }
}
