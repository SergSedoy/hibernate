package ru.netology.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.pojo.City;
import ru.netology.hibernate.pojo.Person;

import java.util.List;
import java.util.Optional;

@Repository
public class HiberRepository{

    @Autowired
    CityRepository cityRepository;

    @Autowired
    PersonRepository personRepository;

    public List<City> getCityByName(String city) {
        return cityRepository.findByName(city);
    }

    public List<Person> getPersonByAge(int age) {
        return personRepository.findByAgeBeforeOrderByAgeAsc (age);
    }

    public Optional<Person> getPersonByName(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}
 