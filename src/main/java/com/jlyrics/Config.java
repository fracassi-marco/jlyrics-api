package com.jlyrics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    public RestOperations httpClient() {
        return new RestTemplate();
    }

    @Bean
    public SearchService searchService(RestOperations httpClient) {
        return new OvhSearchService(httpClient);
    }
}
