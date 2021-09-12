package ru.netology.hibernate.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Person {

    @Id
    private int id;

    private String name;
    private String surname;
    private int age;
    private String phoneNumber;
    private String city_of_living;

}
