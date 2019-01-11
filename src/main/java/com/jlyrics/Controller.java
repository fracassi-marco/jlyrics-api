package com.jlyrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/lyrics")
public class Controller {

    private SearchService searchService;

    @Autowired
    public Controller(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public HashMap<String, String> search(@RequestParam String author, @RequestParam String title) {
        HashMap<String, String> result = new HashMap<>();
        result.put("text", searchService.search(author, title));
        return result;
    }
}
