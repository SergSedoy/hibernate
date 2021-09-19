package ru.netology.hibernate.pojo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper {
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setSurname(rs.getString("surname"));
        person.setAge(rs.getInt("age"));
        person.setPhone_umber(rs.getString("phone_number"));
        person.setCity_of_living(rs.getString("city_of_living"));
        return person;
    }
}
