package com.jlyrics;

import java.sql.Connection;
import java.sql.SQLException;

public class Ratings {
    private Connection connection;

    public Ratings(Connection connection) {
        this.connection = connection;
    }

    public void add(String author, String title, int rating) throws SQLException {
        connection.prepareStatement("CREATE TABLE IF NOT EXISTS rating (author VARCHAR(50), title VARCHAR(50), rating INT);").executeUpdate();
        connection.prepareStatement("INSERT INTO rating VALUES ('" + author +"', '" + title + "', " + rating + ")").executeUpdate();
    }

    public void clean() throws SQLException {
        connection.prepareStatement("TRUNCATE TABLE rating").executeUpdate();
    }
}
