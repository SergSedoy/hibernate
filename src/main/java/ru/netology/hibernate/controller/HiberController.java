package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.pojo.Person;
import ru.netology.hibernate.repository.HiberRepository;

import java.util.List;

@RestController
public class HiberController {
    private final HiberRepository repository;

    public HiberController(HiberRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPerson(@RequestParam ("city") String city) {
        return repository.getPersonsByCity(city);
    }
}
