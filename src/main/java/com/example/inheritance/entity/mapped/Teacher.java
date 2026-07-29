package com.example.inheritance.entity.mapped;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {
    @Column(length = 50)
    private String department;

    @Column(length = 50)
    private String degree;

    private Double salary;

    public Teacher() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "department='" + department + '\'' +
                ", degree='" + degree + '\'' +
                ", salary=" + salary +
                '}';
    }
}
