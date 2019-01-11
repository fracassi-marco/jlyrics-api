package com.jlyrics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestOperations;

import static com.jlyrics.OvhSearchService.LYRICSOVH_ENDPOINT_PROPERTY;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OvhSearchServiceTest {
    private RestOperations httpClient= mock(RestOperations.class);

    @Before
    public void before() {
        System.setProperty(LYRICSOVH_ENDPOINT_PROPERTY, "http://any.url");
    }

    @After
    public void after() {
        System.clearProperty(LYRICSOVH_ENDPOINT_PROPERTY);
    }

    @Test
    public void shouldMakeSearch() {

        when(httpClient.getForObject("http://any.url/v1/U2/Pride", SearchResponse.class))
                .thenReturn(new SearchResponse("text"));

        String result = new OvhSearchService(httpClient).search("U2", "Pride");

        assertThat(result, is("text"));
    }
}
