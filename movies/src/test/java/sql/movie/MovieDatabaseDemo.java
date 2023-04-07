package sql.movie;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sql.DatabaseTools;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

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
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }


}