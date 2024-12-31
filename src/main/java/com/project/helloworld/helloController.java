package com.project.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class helloController {

   @RequestMapping("/hello")
    public String hello(){
        return "Hello World! My Name is Sumaia";
    }
   @RequestMapping("/hi")
    public String hi(){
        return "Hello World! My Name is Sumaia";
    }
}
