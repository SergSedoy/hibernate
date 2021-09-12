package ru.netology.hibernate.repository;

import org.springframework.stereotype.Repository;
import ru.netology.hibernate.pojo.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HiberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery("select p from Person p where p.city_of_living = :city", Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}
 