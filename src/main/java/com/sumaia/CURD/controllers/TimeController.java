package com.sumaia.CURD.controllers;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
public class TimeController {

    @GetMapping("/currentDate")
    public String currentDate() {
        return "Today's date is: " + LocalDate.now();
    }

    @GetMapping("/currentTime")
    public String currentTime() {
        return "The current time is: " + LocalTime.now();
    }
}
