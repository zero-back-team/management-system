package com.zero.memberservice.domain;

import com.zero.memberservice.type.ForeignType;
import com.zero.memberservice.type.Grade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {

    @Id @GeneratedValue
    private Long memberId;
    private String email;
    private String birth;
    private ForeignType foreignType;
    private String id;
    private String passWord;
    private Grade grade; // Bronze, Silver, Gold
    private Long totalAmount;
}
