package ru.netology.hibernate.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/")
    public String greeteng() {
        return "Hello " + SecurityContextHolder.getContext().getAuthentication().getName();
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
    @PreAuthorize("#name == authentication.principal.username")
    public List<Person> getAllPerson(@RequestParam("name") String name){
        return repository.getAllPerson();
    }
}
