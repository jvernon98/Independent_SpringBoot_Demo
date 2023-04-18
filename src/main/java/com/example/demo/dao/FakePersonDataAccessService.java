package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao") //this lets spring know that this class needs to be instantiated as a bean so that
//we can inject it in all the classes or also use @ component, but repository is more obvious
//the fakeDao allows us to use multiple implementations of this interface

public class FakePersonDataAccessService implements PersonDAO{ //a quick way to implement the methods is to use control or command n to generate them for you
    private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }
}
