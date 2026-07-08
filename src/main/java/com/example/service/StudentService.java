package com.example.service;

import com.example.HibernateUtil;
import com.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentService {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Student gwtStudentById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student result ;
            Student student = session.get(Student.class, 49);
            if (student != null) {
                result= student;

            } else {
                result = new Student();
            }
            session.getTransaction().commit();
            return result;
        }
    }
}
