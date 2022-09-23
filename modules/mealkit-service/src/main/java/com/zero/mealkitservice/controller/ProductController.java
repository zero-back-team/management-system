package com.zero.mealkitservice.controller;

import com.zero.mealkitservice.dto.ProductRegisterDto;
import com.zero.mealkitservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RequestMapping("/api/products")
@RestController
@RequiredArgsConstructor // final변수에 대한 생성자 생성
public class ProductController {
     final ProductService productService;

    @PostMapping("/register")
    public ProductRegisterDto.Response registerProduct(
            @RequestBody @Valid ProductRegisterDto.Request request)
    {
//        return ProductRegisterDto.Response.from()
        return productService.registerProduct(request);
    }
}
