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

    private Long price;

    private Long stock;

    private String brand;

    private int calorie;

    private String serving;

    private String category;

    private String briefDescription;

    private String description;

    private String origin;

    private String recipe;

    private String expirationDate;

    private String allergy;

    private String deliveryInfo;

    private String deliveryPeriod;

    private int discountRate;

    private String imageUrl;

    public static ProductDto fromEntity(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .brand(product.getBrand())
                .calorie(product.getCalorie())
                .serving(product.getServing())
                .category(product.getCategory())
                .briefDescription(product.getBriefDescription())
                .description(product.getDescription())
                .origin(product.getOrigin())
                .recipe(product.getRecipe())
                .expirationDate(product.getExpirationDate())
                .allergy(product.getAllergy())
                .deliveryInfo(product.getDeliveryInfo())
                .deliveryPeriod(product.getDeliveryPeriod())
                .discountRate(product.getDiscountRate())
                .imageUrl(product.getImage())
                .build();
    }
}
