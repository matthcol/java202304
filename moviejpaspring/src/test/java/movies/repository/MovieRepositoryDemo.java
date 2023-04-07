package movies.repository;

import movies.entity.Movie;
import movies.enums.PgType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.sql.SQLException;
import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = NONE)
class MovieRepositoryDemo {

    @Autowired
    MovieRepository movieRepository;

    @Test
    void demoFindAll() {
        movieRepository.findAll(Sort.by("year").descending())
                .stream()
                .limit(50)
                .forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings={
            "star wars",
            "jurassic",
            "terminator",
            "lord of the rings"
    })
    void demoReadFilterByTitle(String titlePattern){
        movieRepository.findByTitleContainingIgnoringCaseOrderByYear(titlePattern)
                .forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings={
            "star wars%",
            "%jurassic%",
            "%terminator%",
            "%lord of the rings%"
    })
    void demoReadFilterByTitle2(String titlePattern){
        movieRepository.findByTitle(titlePattern)
                .forEach(System.out::println);
    }
    @Rollback(false)
    @Test
    void demoAddMovies() throws SQLException {
        List<Movie> movies = List.of(
                new Movie(null, "Top Gun", 1984, (short) 109, PgType.PG)
                , new Movie(null, "Top Gun: Maverick", 2022, (short) 130, PgType.PG_13)
                , new Movie(null, "John Wick: Chapter 4", 2023, (short) 169, PgType.R)
        );
        movies.forEach(movieRepository::save);
    }

}