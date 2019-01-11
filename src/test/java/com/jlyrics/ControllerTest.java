package com.jlyrics;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControllerTest {

    private SearchService searchService = mock(SearchService.class);

    @Test
    public void shouldRetrieveText() {
        when(searchService.search("Oasis", "Wanderwall")).thenReturn("Today is gonna be the day");

        HashMap<String, String> result = new Controller(searchService).search("Oasis", "Wanderwall");

        assertThat(result.get("text"), containsString("Today is gonna be the day"));
    }

    /*
    * @Test
    fun shouldRenderLyrics() {
        whenever(searchService.search("Oasis", "Wanderwall")).thenReturn("Today is gonna be the day")

        val template = PagesController(searchService).search(model, "Oasis", "Wanderwall")

        verify(model).addAttribute("text", "Today is gonna be the day")
        assertThat(template).isEqualTo("lyric")
    }*/
}
