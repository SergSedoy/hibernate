package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.pojo.City;
import ru.netology.hibernate.pojo.Person;
import ru.netology.hibernate.repository.HiberRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class HiberController {
    private final HiberRepository repository;

    public HiberController(HiberRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/city/by-name")
    public List<City> getCity(@RequestParam ("city") String city) {
        return repository.getCityByName(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPerson(@RequestParam("age") int age) {
        return repository.getPersonByAge(age);
    }

    @GetMapping("/persons/by-name")
    public Optional<Person> getPerson(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return repository.getPersonByName(name, surname);
    }
}
