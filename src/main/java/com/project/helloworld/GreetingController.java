package com.project.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    @GetMapping("/general")
    public String generalGreeting() {
        return "Hello! Welcome to our application.";
    }

    @GetMapping("/personal/{name}")
    public String personalGreeting(@PathVariable String name) {
        return "Hello, " + name + "! It's great to see you.";
    }
}
