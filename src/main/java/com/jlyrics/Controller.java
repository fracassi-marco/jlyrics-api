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
    private RatingRepository ratingRepository;

    @Autowired
    public Controller(SearchService searchService, RatingRepository ratingRepository) {
        this.searchService = searchService;
        this.ratingRepository = ratingRepository;
    }

    @GetMapping("/search")
    public HashMap<String, Object> search(@RequestParam String author, @RequestParam String title) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("text", searchService.search(author, title));
        result.put("rating", ratingRepository.load(author, title).getValue());
        return result;
    }
}
