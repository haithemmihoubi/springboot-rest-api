package com.haithem.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // http get request
    @GetMapping("/hello-world")
    public  String helloWorld() {
        return  "Hello world" ;
    }
 // post Request




}
