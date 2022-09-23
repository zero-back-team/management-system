package com.zero.mealkitservice.service;

import com.zero.mealkitservice.domain.Product;
import com.zero.mealkitservice.dto.ProductRegisterDto;
import com.zero.mealkitservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductRegisterDto.Response registerProduct(ProductRegisterDto.Request request) {
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .brand(request.getBrand())
                .calorie(request.getCalorie())
                .serving(request.getServing())
                .category(request.getCategory())
                .briefDescription(request.getBriefDescription())
                .description(request.getDescription())
                .origin(request.getOrigin())
                .recipe(request.getRecipe())
                .expirationDate(request.getExpirationDate())
                .allergy(request.getAllergy())
                .deliveryInfo(request.getDeliveryInfo())
                .deliveryPeriod(request.getDeliveryPeriod())
                .discountRate(request.getDiscountRate())
                .build();
        Product savedProduct = productRepository.save(product);

        return ProductRegisterDto.Response.builder()
                .id(savedProduct.getId())
                .name(savedProduct.getName())
                .build();
    }
}
