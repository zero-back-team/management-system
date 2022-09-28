package com.zero.mealkitservice.controller;

import com.zero.mealkitservice.dto.ProductRegisterDto;
import com.zero.mealkitservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;

@RequestMapping("/api/products")
@RestController
@RequiredArgsConstructor // final변수에 대한 생성자 생성
public class ProductController {
     final ProductService productService;

    @PostMapping("/register")
    public ProductRegisterDto.Response registerProduct(
            @RequestPart @Valid ProductRegisterDto.Request request,
            @RequestPart("imageUrl")MultipartFile multipartFile)
    {
//        return ProductRegisterDto.Response.from()
        return productService.registerProduct(request, multipartFile);
    }
}
