package com.zero.mealkitservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private double pointRate;
    private String image;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime lastUpdatedAt;

}
