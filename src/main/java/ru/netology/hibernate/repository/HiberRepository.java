package ru.netology.hibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.pojo.Person;
import ru.netology.hibernate.pojo.PersonMapper;

import java.util.List;
import java.util.Map;

@Repository
public class HiberRepository {
    private final String INSERT_SQL = "INSERT INTO person(id, name, surname, age, phone_number, city_of_living) values (:id,:name,:surname,:age,:phone_number,:city_of_living)";
    private final String DEL_SQL = "DELETE FROM person WHERE id = :id";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    PersonRepository personRepository;

    public List<Person> getPersonByAge(int age) {
        return personRepository.findByAgeBeforeOrderByAgeAsc(age);
    }

    public String createPerson(Person person) {
        namedParameterJdbcTemplate.update(INSERT_SQL, Map.of("id", person.getId(), "name", person.getName(), "surname", person.getSurname(), "age", person.getAge(), "phone_number", person.getPhone_number(), "city_of_living", person.getCity_of_living()));
        return "УСПЕХ!!!";
    }

    public String delPersonById(long id) {
        namedParameterJdbcTemplate.update(DEL_SQL, Map.of("id", id));
        return "УСПЕХ!!!";
    }

    public List<Person> getAllPerson(String name) {
        if(!name.equals(SecurityContextHolder.getContext().getAuthentication().getName()))
            return null;
        return namedParameterJdbcTemplate.query("SELECT * FROM person", new PersonMapper());
    }
}
 