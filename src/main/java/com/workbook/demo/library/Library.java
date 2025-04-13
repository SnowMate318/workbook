package com.workbook.demo.library;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
public class Library {

    @Id @GeneratedValue
    @Column(name = "LIBRARY_ID")
    private long id;

    @JoinColumn(name = "member")
    @Column(nullable = false, length=50)
    @Setter
    private String title;


    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccessAt;


    @PrePersist
    @PreUpdate
    public void onUpdate() {
        this.lastAccessAt = new Date();
    }

}
