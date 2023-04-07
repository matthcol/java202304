package movies.jpa;

import movies.entity.Movie;
import movies.enums.PgType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = NONE)
class MovieJpaDemo {

    @Autowired
    EntityManager entityManager;

    @ParameterizedTest
    @ValueSource(strings={
            "star wars%",
            "jurassic%",
            "%terminator%",
            "%lord of the rings%"
    })
    void demoQuery(String titlePattern) {
        // SQL can be written in JPQL/HQL
        String sql = """
                SELECT m 
                FROM Movie m  
                WHERE lower(m.title) like ?1
                ORDER BY m.title""";
        var movies = entityManager.createQuery(sql, Movie.class)
                .setParameter(1, titlePattern.toLowerCase())
                .getResultList(); // or .getResultStream() or .getSingleResult()
        movies.forEach(System.out::println);
    }

    @Rollback(false)
    @Test
    void demoAdd() {
        List<Movie> movies = List.of(
                new Movie(null,"Top Gun", 1984, (short) 109, PgType.PG)
                , new Movie(null,"Top Gun: Maverick", 2022, (short) 130, PgType.PG_13)
                , new Movie(null,"John Wick: Chapter 4", 2023, (short) 169, PgType.R)
        );
        movies.forEach(entityManager::persist);
    }

}