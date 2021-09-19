package ru.netology.hibernate.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernate.pojo.Person;
import ru.netology.hibernate.repository.HiberRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class HiberController {
    private final HiberRepository repository;

    public HiberController(HiberRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-age")
    @Secured("ROLE_READ")
    public List<Person> getPerson(@RequestParam("age") int age) {
        return repository.getPersonByAge(age);
    }

    @GetMapping("/persons/by-id")
    @PreAuthorize("hasRole('ROLE_DELETE')")
    public String getPerson(@RequestParam("id") long id) {
        return repository.delPersonById(id);
    }

    @PostMapping("/persons/write")
    @RolesAllowed("ROLE_WRITE")
    public String createPerson(@RequestBody Person person) {
        System.out.println(person.getSurname());
        return repository.createPerson(person);
    }

    @GetMapping("/persons/all")
    public List<Person> getAllPerson(String name){
        return repository.getAllPerson(name);
    }
}
