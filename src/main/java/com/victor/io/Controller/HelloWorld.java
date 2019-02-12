package com.victor.io.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @GetMapping("/api")
    @ResponseBody
    public String helloWorld() {
        return "Hello World!";
    }
}
