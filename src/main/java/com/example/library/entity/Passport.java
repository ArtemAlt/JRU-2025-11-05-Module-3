package com.example.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Date;
@Entity
@Table(name = "passports")
public class Passport {
    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "autor_id")
    private Author author;
    private String series;
    private String number;
    @Column(name = "issued_at")
    private Date issuedAt;
    @Column(name = "expires_at")
    private Date expiresAt;
}
