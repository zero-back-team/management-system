package com.zero.mealkitservice.service;

import com.zero.mealkitservice.domain.Product;
import com.zero.mealkitservice.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("상품 등록 테스트")
    void registerProduct() {
        //given
        Product product = Product.builder()
                .name("test1")
                .price(1000L)
                .stock(1L)
                .brand("풀무원")
                .calorie(100)
                .serving("1인분")
                .category("카테고리")
                .briefDescription("짧은설명")
                .description("긴설명")
                .origin("국산")
                .recipe("레시피")
                .expirationDate("유통기한")
                .allergy("알러지")
                .deliveryInfo("배송정보")
                .deliveryPeriod("배송기간")
                .discountRate(10)
                .build();
        //when
        Product savedProduct = productRepository.save(product);

        //then
        assertEquals(savedProduct.getPrice(), 1000L);
    }
}