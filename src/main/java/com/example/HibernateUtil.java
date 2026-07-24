package com.example;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.Genre;
import com.example.library.entity.Passport;
import com.example.library.entity.Publisher;
import com.example.library.entity.Reader;
import com.example.library.entity.ReaderBook;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")  // Загружаем конфигурацию из XML
                    .addAnnotatedClass(Passport.class)
                    .addAnnotatedClass(Genre.class)
                    .addAnnotatedClass(Book.class)
                    .addAnnotatedClass(Author.class)
                    .addAnnotatedClass(Book.class)
                    .addAnnotatedClass(Publisher.class)
                    .addAnnotatedClass(Reader.class)
                    .addAnnotatedClass(ReaderBook.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Ошибка инициализации SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
