package com.workbook.demo.member;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Member {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(nullable = false, unique = true, length=36) // uuid는 36자리
    private String uuid;

    @Column(nullable = false, unique = true, length=254) //email 최대 길이
    private String email;

    @Column(nullable = false, length=50)
    private String userName;

    @Lob
    private String profile;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Member(){}

    public Member(String uuid, String email, String userName, String profile) {
        this.uuid = uuid;
        this.email = email;
        this.userName = userName;
        this.profile = profile;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = new Date(); // Member 객체를 save할때 createdAt이 자동 설정
        this.updatedAt = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = new Date(); // Member 객체를 save할때 createdAt이 자동 설정
    }

    public void updateUserName(String userName) {
        this.userName = userName;
    }


}
