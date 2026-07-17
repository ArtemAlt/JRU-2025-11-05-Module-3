package com.example;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.Genre;
import com.example.users.User;
import com.example.users.UserAvatar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {

//        Author author = new Author("Александр Сергеевич Пушкин", "Российская Империя");
//        Book book1 = new Book("Приключения Тома Сойера",1876, author);
//        Book book2 = new Book("Принц и нищий", 1881, author);

//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//
//            Genre genre = session.get(Genre.class, 4);
//            Genre genre1 = session.get(Genre.class, 1);
//
//            author.setBooks(List.of(book1, book2));
//            book1.addGenre(genre);
//            book2.addGenre(genre);
//            book2.addGenre(genre1);
//
//            session.persist(author);
//            session.getTransaction().commit();
//            String hql = "select b.title, a.name from Book b join b.author a";
//            String hql = "select b.title, g.name from Book b join b.genres g";
//            String hql = "select a.name, b.title from Author a LEFT JOIN a.books b";
//            String hql = "select distinct a.name from Author a JOIN a.books b where b.publicationYear >:year ";
//            List<Object[]> list = session.createQuery(hql, Object[].class).list();
//            for (Object[] o : list) {
//                System.out.println(o[0] + " - " + o[1]);
//            }
//            String hql = "select b.title from Book b join b.genres g where g.name IN (:genres)";
//            String hql = "from Book b where b.id in (:ids)";
//            Query<Book> query = session.createQuery(hql, Book.class);
//            query.setParameter("ids", List.of(1,2,3));
//            System.out.println(query.list());
//            String hqlDesc = "FROM Book ORDER BY publicationYear DESC";
//              String hql = "FROM Book Order by id";
//            Query<Book> query = session.createQuery(hql, Book.class);
//            query.setFirstResult(0);
//            query.setMaxResults(5);
//            System.out.println("=========First five books=======");
//            System.out.println(query.list());
//            System.out.println("=========Next five books=======");
//            query.setFirstResult(5);
//            query.setMaxResults(5);
//            System.out.println(query.list());
//        }

//        System.out.println("Author: " + author);
//        System.out.println("Books: " + author.getBooks().size());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Author author = new Author("Александр Сергеевич Пушкин", "Российская Империя");
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
//            author = session.get(Author.class, 6);
//            System.out.println(author);
//            System.out.println("=====================");
//            session.remove(author);
//            session.persist(author); // insert jsp
//            session.save(author); // insert HN
//            session.merge(author); // insert or update
//            session.update(author);// update HN
//            session.saveOrUpdate(author);// insert or update HN
//            Author load = session.load(Author.class, 1);
//            session.get(Author.class, author.getId());
//            session.find(Author.class, author.getId());
//            session.refresh(author);
//            author.softDelete();
//            session.persist(author);
//
//            session.getTransaction().commit();
            byte[] data = Files.readAllBytes(Path.of(""));
            User user = new User();
            UserAvatar avatar = new UserAvatar();
            avatar.setAvatarData(data);
            avatar.setUser(user);
            session.persist(avatar);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(author);
    }


}