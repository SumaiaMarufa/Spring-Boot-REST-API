package com.project.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/jog/{a}/{b}")
    public String add(@PathVariable int a, @PathVariable int b) {
        return "The sum of " + a + " and " + b + " is " + (a + b);
    }

    @GetMapping("/subtract/{a}/{b}")
    public String subtract(@PathVariable int a, @PathVariable int b) {
        return "The difference between " + a + " and " + b + " is " + (a - b);
    }
}
