package com.workbook.demo.member;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Member {


    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String uuid;
    private String email;
    private String userName;
    private String profile;

    private Date createdAt;
    private Date updatedAt;

    public Member(String uuid, String email, String userName, String profile) {
        this.uuid = uuid;
        this.email = email;
        this.userName = userName;
        this.profile = profile;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
}
