package com.zero.mealkitservice.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PRODUCT_NOT_FOUND("상품이 존재하지 않습니다."),
    FILE_TYPE_ERROR("파일 형식이 잘못되었습니다."),
    FILE_UPLOAD_FAILED("파일 업로드에 실패했습니다.");

    private final String description;
}
