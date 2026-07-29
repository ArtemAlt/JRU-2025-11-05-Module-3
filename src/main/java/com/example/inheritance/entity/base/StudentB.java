package com.example.inheritance.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "students_joined")
@PrimaryKeyJoinColumn(name = "id")
public class StudentB extends PersonB {
    @Column(length = 50)
    private String faculty;

    @Column(name = "year_of_study")
    private Integer yearOfStudy;

    @Column(name = "average_grade")
    private Double averageGrade;

    public StudentB() {
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "faculty='" + faculty + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
