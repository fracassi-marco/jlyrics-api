package com.jlyrics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DbRatingRepositoryTest {

    private Connection connection;
    private Ratings ratings;

    @Before
    public void setUp() throws Exception {
        connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        ratings = new Ratings(connection);
    }

    @After
    public void tearDown() throws Exception {
        ratings.clean();
        connection.close();
    }

    @Test
    public void shouldRetrieveRating() throws SQLException {
        ratings.add("pooh", "anima mia", 5);

        Rating result = new DbRatingRepository(connection).load("pooh", "anima mia");

        assertThat(result.getValue(), is(5));
    }
}
