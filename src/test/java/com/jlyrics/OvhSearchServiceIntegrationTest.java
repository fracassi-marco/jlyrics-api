package com.jlyrics;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class OvhSearchServiceIntegrationTest {
    @Test
    public void shouldCallServer() {
        String result = new OvhSearchService(new Config().httpClient()).search("U2", "Pride");

        assertThat(result, containsString("in the name of love"));
    }
}
