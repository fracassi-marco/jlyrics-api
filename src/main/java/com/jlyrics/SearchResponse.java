package com.jlyrics;

public class SearchResponse {

    private String lyrics;

    public SearchResponse() {}

    public SearchResponse(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}
