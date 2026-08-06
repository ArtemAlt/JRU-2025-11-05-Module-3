package com.example.library.entity;

import com.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorDAO {
    private final SessionFactory sessionFactory;

    public AuthorDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Author getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Author.class, id);
        }
    }

    public List<Author> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Author", Author.class).list();
        }
    }

    public List<Author> getByCountry(String country) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                    "FROM Author WHERE country = :country", Author.class
            ).setParameter("country", country).list();
        }
    }

    public List<AuthorDto> getDtoByCountry(String country) {
        try (Session session = sessionFactory.openSession()) {
            List<Author> list = session.createQuery(
                    "FROM Author WHERE country = :country", Author.class
            ).setParameter("country", country).list();

            return list.stream().map(AuthorDto::new).collect(Collectors.toList());
        }
    }

    public List<AuthorStatDTO> getAuthorDtoStat() {
        try (Session session = sessionFactory.openSession()) {
            String sql = "SELECT a.id as id, a.name as name, count(b.id) as totalCount from authors a\n" +
                    "    left join books b on b.author_id = a.id group by a.id, a.name";

            return session.createNativeQuery(sql)
                    .addScalar("id", Integer.class)
                    .addScalar("name", String.class)
                    .addScalar("totalCount", Integer.class)
                    .setResultTransformer(Transformers.aliasToBean(AuthorStatDTO.class))
                    .list();
        }
    }
}
