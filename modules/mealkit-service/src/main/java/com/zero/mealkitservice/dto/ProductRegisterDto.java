package com.zero.mealkitservice.dto;

import lombok.*;

import javax.validation.constraints.*;

public class ProductRegisterDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {

        @NotBlank
        private String name;

        @Min(0)
        @NotNull
        private Long price;

        @Min(0)
        @NotNull
        private Long stock;

        @NotBlank
        private String brand;

        @Min(0)
        private int calorie;

        @NotBlank
        private String serving;

        @NotBlank
        private String category;

        @NotBlank
        private String briefDescription;

        private String description;

        @NotBlank
        private String origin;

        @NotBlank
        private String recipe;

        @NotBlank
        private String expirationDate;

        @NotBlank
        private String allergy;

        @NotBlank
        private String deliveryInfo;

        @NotBlank
        private String deliveryPeriod;

        @NotNull
        @Min(0)
        @Max(100)
        private int discountRate;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long id;
        private String name;

        public static Response from(ProductDto productDto) {
            return Response.builder()
                    .id(productDto.getId())
                    .name(productDto.getName())
                    .build();
        }
    }
}
