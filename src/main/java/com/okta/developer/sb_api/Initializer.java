package com.okta.developer.sb_api;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.okta.developer.sb_api.model.Group;
import com.okta.developer.sb_api.model.GroupRepository;

@Component
public class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    public void run(String... strings) {
        Stream.of("Lagos JG", "Nairobi JG", "London JG", 
            "Atlanta JG").forEach(name ->
            repository.save(new Group(name))
        );
        
        Group djug = repository.findByName("Lagos JG"); 
        Event e = Event
    }
    
}
