package com.example.library.entity;

import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

public class GenericAuthorDAO extends GenericDAO<Author, Long> {

    public GenericAuthorDAO(Class<Author> entityClass) {
        super(entityClass);
    }

    public List<AuthorDto> getDtoByCountry(String country) {
        try (Session session = sessionFactory.openSession()) {
            List<Author> list = session.createQuery(
                    "FROM Author WHERE country = :country", Author.class
            ).setParameter("country", country).list();

            return list.stream().map(AuthorDto::new).collect(Collectors.toList());
        }
    }
}
