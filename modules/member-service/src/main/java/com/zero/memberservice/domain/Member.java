package com.zero.memberservice.domain;

import com.zero.memberservice.type.ForeignType;
import com.zero.memberservice.type.Grade;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Builder
    private Member(String email, String birth, ForeignType foreignType, String id, String passWord, Grade grade, Long totalAmount) {
        this.email = email;
        this.birth = birth;
        this.foreignType = foreignType;
        this.id = id;
        this.passWord = passWord;
        this.grade = grade;
        this.totalAmount = totalAmount;
    }
}
