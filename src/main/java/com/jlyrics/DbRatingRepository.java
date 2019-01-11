package com.jlyrics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbRatingRepository implements RatingRepository {
    private Connection connection;

    public DbRatingRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Rating load(String author, String title) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT rating FROM rating WHERE author = ? AND title = ?");
            preparedStatement.setObject(1, author);
            preparedStatement.setObject(2, title);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new Rating(resultSet.getInt("rating"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Rating(0);
    }
}
