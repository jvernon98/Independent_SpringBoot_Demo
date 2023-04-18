package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micrometer.observation.transport.Propagator;

import java.util.UUID;

public class Person {

    private final UUID id;
    private final String name;

    public Person(@JsonProperty("id") UUID id, //we created the key value json pairs in postman, its just defining the json properties
                  @JsonProperty("name") String name){ //so using this is how spring knows to take the name and key (name : james bond) and convert it into a java class
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
