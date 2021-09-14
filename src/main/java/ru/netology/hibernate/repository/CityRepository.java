package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.hibernate.pojo.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByName(String city);
}
