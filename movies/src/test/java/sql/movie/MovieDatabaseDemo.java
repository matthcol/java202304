package sql.movie;

import model.MovieL;
import model.PgType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import sql.DatabaseTools;

import javax.sql.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        String sql = """
                SELECT id, title, year, duration, pg
                FROM movies 
                WHERE year = 1984 
                ORDER BY title""";
        List<MovieL> movies = new ArrayList<>();
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
                movies.add(movie);
//                System.out.println(movie);
            }
        } // close resultSet, statement, connection
        System.out.println(movies);
    }

    @Test
    void demoReadFromDbWithArg() throws SQLException {
        String sql = """
                SELECT id, title, year, duration, pg
                FROM movies 
                WHERE year = ? 
                ORDER BY title""";
        List<MovieL> movies = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            for (int yearQuery: List.of(1984, 1993, 2019)) {
                // provide values for each arg of the preparedStatement
                statement.setInt(1, yearQuery);
                // execute query
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String title = resultSet.getString("title");
                        int year = resultSet.getInt("year");
                        short duration = resultSet.getShort("duration");
                        String pgStr = resultSet.getString("pg");
                        PgType pg = PgType.valueOf(pgStr);
                        MovieL movie = new MovieL(title, year, duration, pg);
                        movies.add(movie);
                    }
                }
            }
        } // close resultSet, statement, connection
        System.out.println(movies);
        movies.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings={
            "star wars%",
            "jurassic%",
            "%terminator%",
            "%lord of the rings%"
    })
    void demoReadFromDbWithArgString(String titlePattern) throws SQLException {
        String sql = """
                SELECT id, title, year, duration, pg
                FROM movies 
                WHERE title ilike ? 
                ORDER BY title""";
        List<MovieL> movies = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            // provide values for each arg of the preparedStatement
            statement.setString(1, titlePattern);
            // execute query
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    int year = resultSet.getInt("year");
                    short duration = resultSet.getShort("duration");
                    String pgStr = resultSet.getString("pg");
                    PgType pg = PgType.valueOf(pgStr);
                    MovieL movie = new MovieL(title, year, duration, pg);
                    movies.add(movie);
                }
            }
        } // close resultSet, statement, connection
        System.out.println(movies);
        movies.forEach(System.out::println);
    }

    @Test
    void demoAddMovies() throws SQLException {
        List<MovieL> movies = List.of(
                new MovieL("Top Gun", 1984, (short) 109, PgType.PG)
                , new MovieL("Top Gun: Maverick", 2022, (short) 130, PgType.PG_13)
                , new MovieL("John Wick: Chapter 4", 2023, (short) 169, PgType.R)
        );
        // insert these 3 movies in the database
        // NB: use executeUpdate for INSERT, UPDATE, DELETE
        String sql = """
                INSERT INTO movies (title, year, duration, pg)
                VALUES (?, ?, ?, ?)""";
        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            //connection.setAutoCommit(true);
            for (MovieL movie: movies) {
                // set query args
                preparedStatement.setString(1, movie.getTitle());
                preparedStatement.setInt(2, movie.getYear());
                preparedStatement.setShort(3, movie.getDuration());
                preparedStatement.setString(4, movie.getPg().name());
                // execute update query
                preparedStatement.executeUpdate();
            }
        }
    }

}