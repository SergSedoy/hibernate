create schema netology;

create table person (
        id int primary key auto_increment,
        name varchar(255) not null,
        surname varchar(255) not null,
        age int check (age > 0),
        phone_number varchar(255),
        city_of_living varchar(255)
);

insert into person (name, surname, age, phone_number, city_of_living) values ('serg', 'sedoy', 33, '89998887755', 'London');
insert into person (name, surname, age, phone_number, city_of_living) values ('oleg', 'petrov', 22, '89998887755', 'Saint Petersburg');
insert into person (name, surname, age, phone_number, city_of_living) values ('alexey', 'sergeev', 12, '81112223344', 'Moscow');
insert into person (name, surname, age, phone_number, city_of_living) values ('igor','igorev' , 42, '89211111111', 'Madrid');
insert into person (name, surname, age, phone_number, city_of_living) values ('vasya', 'boroda', 15, '89317899999', 'Saint Petersburg');

create table city (
                        id int primary key auto_increment,
                        name varchar(255) not null,
                        person_id int,
                        FOREIGN KEY (person_id) REFERENCES person (id)
);

insert into city (name, person_id) values ('London', 1);
insert into city (name, person_id) values ('Saint Petersburg', 2);
insert into city (name, person_id) values ('Moscow', 3);