package com.example;

import com.example.inheritance.entity.mapped.Student;
import com.example.library.entity.Author;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaDelete;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaCriteriaUpdate;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<Author> query = criteriaBuilder.createQuery(Author.class);
//            Root<Author> from = query.from(Author.class); // from authors
//            // select * from authors Where country = 'Россия'
//            Predicate equal = criteriaBuilder.equal(from.get("country"), "Россия"); //country = 'Россия'
//
//            // Where birthYear > 1830
//            Predicate birthYear = criteriaBuilder.gt(from.get("birthYear"), 1830);
//            // select * from   // Where
//            query.select(from).where(criteriaBuilder.and(equal, birthYear));
//
//            List<Author> resultList = session.createQuery(query).getResultList();
//            for (Author author : resultList) {
//                System.out.println(author);
//            }
//            query.select(from).orderBy(
//                    criteriaBuilder.asc(from.get("id")),
//                    criteriaBuilder.desc(from.get("country"))
//            );
//            List<Author> resultList = session.createQuery(query).getResultList();
//            for (Author author : resultList) {
//                System.out.println(author);
//            }
            // SELECT country, COUNT(*) FROM Author GROUP BY country
//            JpaCriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
//            JpaRoot<Author> root = query.from(Author.class);
//
//            query.multiselect(
//                   root.get("country"),
//                   criteriaBuilder.count(root)
//            ).groupBy(root.get("country"));
//
//            List<Object[]> resultList = session.createQuery(query).getResultList();
//            for (Object[] row : resultList) {
//                System.out.println(row[0] + " " + row[1]);
//            }

//            String nameFilter = "";
//            String countryFilter = "Великобритания";
//            Integer minAgeFilter = 1700;
//            Integer maxAgeFilter = 1800;
//
//            JpaCriteriaQuery<Author> query = criteriaBuilder.createQuery(Author.class);
//            JpaRoot<Author> root = query.from(Author.class);
//
//            List<Predicate> predicates = new ArrayList<>();
//            if (nameFilter != null && !nameFilter.isEmpty()) {
//                predicates.add(criteriaBuilder.like(root.get("name"), "%" + nameFilter + "%")); // like '%Лев%'
//            }
//
//            if (countryFilter != null && !countryFilter.isEmpty()) {
//                predicates.add(criteriaBuilder.equal(root.get("country"), countryFilter));
//            }
//
//            if (minAgeFilter != null) {
//                predicates.add(criteriaBuilder.ge(root.get("birthYear"), minAgeFilter));
//            }
//
//            if (maxAgeFilter != null) {
//                predicates.add(criteriaBuilder.le(root.get("birthYear"), maxAgeFilter));
//            }
//
//            query.select(root).where(predicates.toArray(new Predicate[0]));
//            List<Author> resultList = session.createQuery(query).getResultList();
//            for (Author author : resultList) {
//                System.out.println(author);
//            }

//            JpaCriteriaUpdate<Author> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Author.class);
//            Root<Author> root = criteriaUpdate.from(Author.class);
//
//
//            criteriaUpdate.set(root.get("birthYear"), 2000)
//                    .where(criteriaBuilder.equal(root.get("id"),1));
//
//            int countLines = session.createMutationQuery(criteriaUpdate).executeUpdate();
//            System.out.println(countLines);

            JpaCriteriaDelete<Author> criteriaDelete = criteriaBuilder.createCriteriaDelete(Author.class);
            Root<Author> root = criteriaDelete.from(Author.class);
            criteriaDelete.where(criteriaBuilder.equal(root.get("id"), 1));
            int i = session.createMutationQuery(criteriaDelete).executeUpdate();
            session.getTransaction().commit();
            System.out.println(i);
        }
    }
}
/*
a = b	            builder.equal(a, b)
a < b	            builder.lt(a, b)
a > b	            builder.gt(a, b)
a <= b	            builder.le(a, b)
a >= b	            builder.ge(a, b)
a != b	            builder.notEqual(a, b)
a LIKE b	        builder.like(a, b)
a BETWEEN c AND d	builder.between(a, c, d)
a IS NULL	        builder.isNull(a)
a IS NOT NULL	    builder.isNotNull(a)
a IN (b, c, d)	    builder.in(a).value(b).value(c).value(d)
a AND b	            builder.and(a, b)
a OR b	            builder.or(a, b)
NOT a	            builder.not(a)
 */