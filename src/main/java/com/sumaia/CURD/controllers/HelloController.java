package com.sumaia.CURD.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

   @RequestMapping("/hello")
    public String hello(){
        return "Hello World! My Name is Sumaia";
    }
   @RequestMapping("/hi")
    public String hi(){
        return "Hello World! My Name is Sumaia";
    }
}
