package com.sumaia.CURD.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumaia.CURD.models.Person;

@RestController
// @RequestMapping("/greet")
public class GreetingController {

    @GetMapping("/general")
    public String generalGreeting() {
        return "Hello! Welcome to our application.";
    }

    @GetMapping("/personal/{name}")
    public String personalGreeting(@PathVariable String name) {
        return "Hello, " + name + "! It's great to see you.";
    }

    @PostMapping("/personal")
    public ResponseEntity<String> greetPerson(@RequestBody Person person) {
        String personName = person.getPersonName();
        String greetingMessage = "Hello, " + personName + "! It's great to see you.";
        return ResponseEntity.ok(greetingMessage);
    }

}
