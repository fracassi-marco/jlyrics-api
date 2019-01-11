package com.jlyrics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public SearchService searchService() {
        return new OvhSearchService();
    }
}
