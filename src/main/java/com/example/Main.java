package com.example;

import com.example.inheritance.entity.base.PersonB;
import com.example.inheritance.entity.base.StudentB;
import com.example.inheritance.entity.base.TeacherB;
import com.example.inheritance.entity.single.PersonS;
import com.example.inheritance.entity.single.StudentS;
import com.example.inheritance.entity.single.TeacherS;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Создаём студента
            StudentB studentS = new StudentB();
            studentS.setName("Иван Петров");
            studentS.setEmail("ivan@example.com");
            studentS.setFaculty("Информатика");
            studentS.setYearOfStudy(3);
            studentS.setAverageGrade(4.5);

            // Создаём преподавателя
            TeacherB teacherS = new TeacherB();
            teacherS.setName("Анна Смирнова");
            teacherS.setEmail("anna@example.com");
            teacherS.setDepartment("Математика");
            teacherS.setDegree("Кандидат наук");
            teacherS.setSalary(75000.0);

            session.persist(studentS);
            session.persist(teacherS);

            session.getTransaction().commit();

//            List<Student> fromStudent = session.createQuery("FROM Student", Student.class).list();
//            List<Teacher> fromTeacher = session.createQuery("FROM Teacher", Teacher.class).list();

//            for (Student s : fromStudent) {
//                System.out.println(s.toString());
//            }
//            for (Teacher t : fromTeacher) {
//                System.out.println(t.toString());
//            }
            List<PersonB> fromPersonS = session.createQuery("From PersonB ", PersonB.class).list();

            for (PersonB personS : fromPersonS) {
                System.out.println(personS.toString());
            }
        }
    }
}