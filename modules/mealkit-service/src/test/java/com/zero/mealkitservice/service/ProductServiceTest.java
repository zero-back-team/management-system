package com.zero.mealkitservice.service;

import com.zero.mealkitservice.domain.Product;
import com.zero.mealkitservice.dto.ProductDto;
import com.zero.mealkitservice.dto.ProductRegisterDto;
import com.zero.mealkitservice.exception.CustomException;
import com.zero.mealkitservice.repository.ProductRepository;
import com.zero.mealkitservice.type.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Mock
    private AwsS3Service awsS3Service;

    @Test
    @DisplayName("상품 조회 - 성공")
    void searchProduct() {
        //given
        MockMultipartFile file = new MockMultipartFile("test", "test.png", "image/png", "test".getBytes());

        String url = awsS3Service.uploadFile(file);

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
                .image(url)
                .build();

        given(productRepository.findById(anyLong()))
                .willReturn(Optional.of(product));

        //when
        ProductDto findProduct = productService.searchProduct(1L);

        //then
        assertEquals("test1", findProduct.getName());
        assertEquals(url, product.getImage());
    }

    @Test
    @DisplayName("상품 조회 - 상품이 존재하지 않는 경우")
    void searchProduct_ProductNotFound() {
        //then
        given(productRepository.findById(anyLong()))
                .willReturn(Optional.empty());

        //when & then
        CustomException customException = assertThrows(CustomException.class, ()
                -> productService.searchProduct(1L));

        assertEquals(ErrorCode.PRODUCT_NOT_FOUND, customException.getErrorCode());
    }

    @Test
    @DisplayName("상품 등록 테스트")
    void registerProduct() {
        //given
        MockMultipartFile file = new MockMultipartFile("test", "test.png", "image/png", "test".getBytes());

        String url = awsS3Service.uploadFile(file);

        Product product = Product.builder()
                .id(1L)
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
                .image(url)
                .build();

        given(productRepository.save(any()))
                .willReturn(product);

        ArgumentCaptor<Product> captor = ArgumentCaptor.forClass(Product.class);

        //when
        ProductRegisterDto.Response registerProduct = productService.registerProduct(ProductRegisterDto.Request.builder()
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
                .build(), file);

        //then
        verify(productRepository, times(1)).save(captor.capture());
        assertEquals(1L, registerProduct.getId());
        assertEquals(1000L, captor.getValue().getPrice());
    }
}