package com.okta.developer.sb_api;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.okta.developer.sb_api.model.Event;
import com.okta.developer.sb_api.model.Group;
import com.okta.developer.sb_api.model.GroupRepository;

@Component
public class Initializer implements CommandLineRunner {    // this initilizer is used to load some default data into the database 

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Lagos JG", "Nairobi JG", "London JG", 
                "Atlanta JG").forEach(name ->
                repository.save(new Group())
        );
        
        Group djug = repository.findByName("Lagos JG"); 
        Event e = Event.builder().title("xxxxx for Java Developers")
                .description("Jhxxxx now has microfrontend support!")
                .date(Instant.parse("2024-05-13T17:00:00.000Z"))
                .build(); 
        djug.setEvents(Collections.singleton(e)); 
        repository.save(djug);

        repository.findAll().forEach(System.out::println);
    
    }
    
}
