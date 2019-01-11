package com.jlyrics;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControllerTest {

    private SearchService searchService = mock(SearchService.class);
    private RatingRepository ratingRepository = mock(RatingRepository.class);
    private Controller controller;

    @Before
    public void setUp() throws Exception {
        when(searchService.search("Oasis", "Wanderwall")).thenReturn("ignore");
        when(ratingRepository.load("Oasis", "Wanderwall")).thenReturn(new Rating(-1));

        controller = new Controller(searchService, ratingRepository);
    }

    @Test
    public void shouldRetrieveText() {
        when(searchService.search("Oasis", "Wanderwall")).thenReturn("Today is gonna be the day");

        HashMap<String, Object> result = controller.search("Oasis", "Wanderwall");

        assertThat(result.get("text").toString(), containsString("Today is gonna be the day"));
    }

    @Test
    public void shouldRetrieveRating() {
        when(ratingRepository.load("Oasis", "Wanderwall")).thenReturn(new Rating(4));

        HashMap<String, Object> result = controller.search("Oasis", "Wanderwall");

        assertThat(result.get("rating"), is(4));
    }
}
