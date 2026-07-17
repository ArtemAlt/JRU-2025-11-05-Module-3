package com.example.users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.NumericBooleanConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(unique = true)
    private String email;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_verified",columnDefinition = "INTEGER")
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isVerified = false;

    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "registration_time")
    private LocalDateTime registrationTime;
    @Column(name = "last_login_time")
    private LocalTime lastLoginTime;
    private Integer height;
    private Integer weight;

    @Formula(value = "height * weight")
    private Integer bodyMassIndex;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Formula(value = "(SELECT AVG(e.grade) FROM enrollments e WHERE e.student_id = id)")
    private Double averageGrade;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserAvatar avatar;
}
