package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.hibernate.pojo.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByAge(int age);

    List<Person> findByAgeBeforeOrderByAgeAsc(int age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}
