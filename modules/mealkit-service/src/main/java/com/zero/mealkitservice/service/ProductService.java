package com.zero.mealkitservice.service;

import com.zero.mealkitservice.domain.Product;
import com.zero.mealkitservice.dto.ProductDto;
import com.zero.mealkitservice.dto.ProductRegisterDto;
import com.zero.mealkitservice.exception.CustomException;
import com.zero.mealkitservice.repository.ProductRepository;
import com.zero.mealkitservice.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final AwsS3Service awsS3Service;

    public ProductDto searchProduct(Long productId) {

        return ProductDto.fromEntity(productRepository.findById(productId)
                .orElseThrow(() -> new CustomException(ErrorCode.PRODUCT_NOT_FOUND)));
    }

    @Transactional
    public ProductRegisterDto.Response registerProduct(ProductRegisterDto.Request request,
                                                       MultipartFile multipartFile) {
        String fileName = awsS3Service.uploadFile(multipartFile);

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
                .image(fileName)
                .build();

        Product savedProduct = productRepository.save(product);

        return ProductRegisterDto.Response.builder()
                .id(savedProduct.getId())
                .name(savedProduct.getName())
                .build();
    }
}
