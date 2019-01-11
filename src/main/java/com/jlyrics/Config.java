package com.jlyrics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.sql.DriverManager;
import java.sql.SQLException;

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

    @Bean
    public RatingRepository ratingRepository() throws SQLException {
        return new DbRatingRepository(DriverManager.getConnection("jdbc:h2:~/test", "sa", ""));
    }
}
