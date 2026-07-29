package com.example.inheritance.entity.single;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Teacher")
public class TeacherS extends PersonS {
    @Column(length = 50)
    private String department;

    @Column(length = 50)
    private String degree;

    private Double salary;

    public TeacherS() {
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
