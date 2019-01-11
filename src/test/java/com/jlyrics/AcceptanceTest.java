package com.jlyrics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcceptanceTest {

    @LocalServerPort
    private int port;

    private URL base;
    private Connection connection;
    private Ratings ratings;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
        connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        ratings = new Ratings(connection);
    }

    @After
    public void tearDown() throws Exception {
        ratings.clean();
        connection.close();
    }

    @Test
    public void shouldReturnText() {
        given()
            .queryParam("author", "Aqua")
            .queryParam("title", "Barbie Girl")
        .when()
            .get(base + "lyrics/search")
        .then()
            .statusCode(200)
            .body("text", containsString("can brush my hair"));
    }

    @Test
    public void shouldReturnRating() throws SQLException {
        ratings.add("Aqua", "Barbie Girl", 8);

        given()
            .queryParam("author", "Aqua")
            .queryParam("title", "Barbie Girl")
        .when()
            .get(base + "lyrics/search")
        .then()
            .statusCode(200)
            .body("rating", is(8));
    }
}
