package com.example.post.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
//mark this class as rest controller
@RestController
@RequestMapping("/api") // base URL for this controller
public class Postcontroller {
    
    
    //Define a POST endpoint
    @PostMapping("/post")
    public ResponseEntity<String> postMessage(@RequestBody String message)
    {
        //log the received message to the console
        System.out.println("Recieved message:"+ message);

        //return a response to the client 
        return ResponseEntity.ok("Message recieved:"+ message);
    }
}
