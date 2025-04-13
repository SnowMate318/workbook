package com.workbook.demo.directory;

import com.workbook.demo.library.Library;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Directory {

    @Id
    @GeneratedValue
    @Column(name = "DIRECTORY_ID")
    private Long id;

    @Column(nullable=false, length = 50)
    private String title;

    @Lob
    private String concept;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccessAt;

    private boolean isScrap;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    Library library;

    @PrePersist
    public void onCreate() {
        this.lastAccessAt = new Date();
        this.isScrap = false;
    }

    @PreUpdate
    public void onUpdate() {
        this.lastAccessAt = new Date();
    }



}
