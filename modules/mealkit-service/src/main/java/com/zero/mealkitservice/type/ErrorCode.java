package com.zero.mealkitservice.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PRODUCT_NOT_FOUND("상품이 존재하지 않습니다.");

    private final String description;
}
