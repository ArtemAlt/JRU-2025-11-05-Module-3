package com.example;

import com.example.entity.Passport;
import com.example.entity.Student;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.Genre;
import com.example.service.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Author author = new Author("Марк Твен", "Англия");
            Book book1 = new Book("Приключения Тома Сойера",1876, author);
            Book book2 = new Book("Принц и нищий", 1881, author);
            Genre genre = session.get(Genre.class, 4);
            Genre genre1 = session.get(Genre.class, 1);

            author.setBooks(List.of(book1, book2));
            book1.addGenre(genre);
            book2.addGenre(genre);
            book2.addGenre(genre1);

            session.persist(author);
            session.getTransaction().commit();

            System.out.println("Author: " + author);
            System.out.println("Books: " + author.getBooks().size());

        }

    }
}