package com.example.demo.service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //this lets everyone looking at your code know that this is the service
public class PersonService {
    public final PersonDAO personDAO; //the interface not the concrete class
    @Autowired //into the PersonDAO interface
    public PersonService(@Qualifier("fakeDao") PersonDAO personDAO) { //and thus, this lets spring know we are injecting into the actual constructor when using @ service
        this.personDAO = personDAO;
    }
    //autowiring allows for multiple implementations of the PersonDAO interface so the @ qualifier allows us to distinguish the dif implementations

        public int addPerson(Person person){
            return personDAO.insertPerson(person);
        }

        public List<Person> getAllPeople(){
        return personDAO.selectAllPeople();
        }
    }
