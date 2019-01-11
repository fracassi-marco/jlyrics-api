package com.jlyrics;

import org.springframework.web.client.RestOperations;

public class OvhSearchService implements SearchService {

    public static String LYRICSOVH_ENDPOINT_PROPERTY = "LYRICSOVH_ENDPOINT_PROPERTY";
    private RestOperations httpClient;

    public OvhSearchService(RestOperations httpClient) {

        this.httpClient = httpClient;
    }

    @Override
    public String search(String author, String title) {
        String endpoint = System.getProperty(LYRICSOVH_ENDPOINT_PROPERTY, "https://api.lyrics.ovh");
        return httpClient.getForObject(endpoint + "/v1/" + author + "/" + title, SearchResponse.class).getLyrics();
    }
}
