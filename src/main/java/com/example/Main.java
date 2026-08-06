package com.example;

import com.example.library.entity.Author;
import com.example.library.entity.AuthorDAO;
import com.example.library.entity.AuthorDto;
import com.example.library.entity.AuthorStatDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//        try (Session session = sessionFactory.openSession()) {
////            String sql = "Select * from authors";
////            List<Object []> result = session.createNativeQuery(sql).list();
////            for (Object [] row : result) {
////                System.out.println("ID: " + row[0] + " Name: " + row[1] );
////            }
////            String sql = "SELECT * FROM authors WHERE id = :id";
////            Author author = session.createNativeQuery(sql, Author.class)
////                    .setParameter("id", 1).getSingleResult();
////            System.out.println(author);
//
////            String sql = "SELECT a.id as id, a.name as name, count(b.id) as totalCount from authors a\n" +
////                    "    left join books b on b.author_id = a.id group by a.id, a.name";
////
////            List<AuthorStatDTO> list = session.createNativeQuery(sql)
////                    .addScalar("id", Integer.class)
////                    .addScalar("name", String.class)
////                    .addScalar("totalCount", Integer.class)
////                    .setResultTransformer(Transformers.aliasToBean(AuthorStatDTO.class))
////                    .list();
////            for (AuthorStatDTO authorStatDTO : list) {
////                System.out.println(authorStatDTO);
////            }
//        }
        AuthorDAO authorDAO = new AuthorDAO();
//        List<Author> all = authorDAO.getAll();
//        for (Author author : all) {
//            System.out.println(author);
//        }
//
//        Author byId = authorDAO.getById(1L);
//        System.out.println(byId);

//        List<AuthorStatDTO> authorDtoStat = authorDAO.getAuthorDtoStat();
//        for (AuthorStatDTO authorStatDTO : authorDtoStat) {
//            System.out.println(authorStatDTO);
//        }

        List<AuthorDto> ru = authorDAO.getDtoByCountry("Россия");
        ru.forEach(System.out::println);


    }
}