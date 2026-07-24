package com.example;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

//        try (Session session = sessionFactory.openSession()) {
//            List<Author> fromAuthor = session.createQuery("FROM Author", Author.class).list();
//            for (Author author : fromAuthor) {
//                System.out.println(author.getName() + ": "+ author.getBooks().size());
//            }
//        }
//        - 15 запросов
//        try (Session session = sessionFactory.openSession()) {
//            String hql = "SELECT DISTINCT a FROM Author a LEFT JOIN FETCH a.books";
//            List<Author> list = session.createQuery(hql, Author.class).list();
//            for (Author author : list) {
//                System.out.println(author + ": " + author.getBooks());
//            }
// - 7 запросов
//        }
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        try (Session session = sessionFactory.openSession()) {
//            for (int i = 0; i < 50; i++) {
//                Author author = session.get(Author.class, 1);
//                System.out.println(i);
//            }
//        }
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        for (int i = 0; i < 50; i++) {
            try (Session session = sessionFactory.openSession()) {
                Author author = session.get(Author.class, 1);
            }
            System.out.println(i);
        }
    }
}