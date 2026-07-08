package com.example;

import com.example.entity.Passport;
import com.example.entity.Student;
import com.example.service.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//        try (Session session = sessionFactory.openSession()) {
//            Student student = session.get(Student.class, 1);
//            if (student != null) {
//                System.out.println(student);
//            } else {
//                System.out.println(" Student not found");
//            }
//            Student student = new Student("Иван1", "Петров1", 20, "ivan.petrov22@example.com",
//                    "899952541", "Москва");
//            session.save(student);
//            session.beginTransaction();
//            Student student = new Student();
//            student.setFirstName("John");
//            student.setLastName("Doe");
//            student.setEmail("john.doe@example.com");
//            student.setAge(25);
//            student.setPhone("5469946164");
//            session.persist(student);
//            session.getTransaction().commit();
//            session.beginTransaction();
//            Student student = session.get(Student.class, 10);
//            if (student != null) {
//                student.setFirstName("John22");
//                student.setAge(99);
//                session.getTransaction().commit();
//            } else {
//                System.out.println("Student not found");
//            }
//            session.beginTransaction();
//            Student student = new Student();
//            student.setFirstName("John12");
//            student.setLastName("Smith");
//            student.setEmail("john.smith@gmail.com");
//            student.setAge(30);
//            student.setCity("London");
//
//            Passport passport = new Passport();
//            passport.setSeries("654915");
//            passport.setNumber("12345");
//            passport.setStudent(student);
//            student.setPassport(passport);
//
//            session.persist(student);
//            session.getTransaction().commit();
//            System.out.println("Student created with id " + student.getId());
//            System.out.println("Passport created with id " + passport.getId());

//            Student student = session.get(Student.class, 49);
//            if (student != null) {
//                System.out.println(student);
//                System.out.println(student.getPassport());
//            } else {
//                System.out.println("Student not found");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        StudentService studentService = new StudentService();
        Student student = studentService.gwtStudentById(49);

        Passport passport = student.getPassport();
        System.out.println(passport);
    }
}