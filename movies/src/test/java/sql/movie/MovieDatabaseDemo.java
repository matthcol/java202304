package sql.movie;

import model.MovieL;
import model.PgType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sql.DatabaseTools;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class MovieDatabaseDemo {

    static DataSource dataSource;

    @BeforeAll
    static void initDataSource(){
        dataSource = DatabaseTools.initDataSourcePostgreSQL(
                "localhost",
                5433, // default 5432
                "dbmovie", // default postgres
                "movie",
                "password"
        );
    }

    @Test
    void testConnection() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println(connection);
            // Do something with the connection
        } // connection.close(); // for all scenarii (normal, exception,...)
    }

    @Test
    void demoReadFromDb() throws SQLException {
        String sql = "SELECT id, title, year, duration, pg FROM movies WHERE year = 1984";
        try (
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int year = resultSet.getInt("year");
                short duration = resultSet.getShort("duration");
                String pgStr = resultSet.getString("pg");
                PgType pg = PgType.valueOf(pgStr);
//                System.out.println(id
//                        + " " + title
//                        + " " + year
//                        + " " + duration
//                        + " " + pgStr
//                 );
                MovieL movie = new MovieL(title, year, duration, pg);
                System.out.println(movie);
            }
            System.out.println(resultSet);
        } // close resultSet, statement, connection
    }


}