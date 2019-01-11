package com.jlyrics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lyrics")
public class Controller {

    @GetMapping("/search")
    public String search(@RequestParam String author, @RequestParam String title) {
        return "Greetings from Spring Boot!";
    }

}
