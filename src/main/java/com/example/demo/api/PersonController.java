package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person") //this gives it the path to the postman client, and gives us our very first endpoint in springboot
@RestController //what does this do
public class PersonController {

    private final PersonService personService;
    @Autowired //look up dependency injection
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //we want to add a person from a client... so use postman! bc we dont have an actual app
    //this will send a person to our server
    @PostMapping //this tells spring that this method will be used to add to the database
    public void addPerson(@RequestBody Person person){ //theres no code at the writing of this that tell this method that this will be used as a post/get/delete
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
}
//bc we are generating the id in the server we dont need to send it from postman, but we do need to send the name
//@ request body is saying that bc we have a json object, itll turn it into a person