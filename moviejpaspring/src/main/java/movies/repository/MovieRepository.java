package movies.repository;

import movies.entity.Movie;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Stream<Movie> findByYearOrderByTitle(int year);
    Stream<Movie> findByYearBetween(int year1, int year2, Sort sort);
    Stream<Movie> findByTitleContainingIgnoringCaseOrderByYear(String title);

    @Query("""
            SELECT m
            FROM Movie m
            WHERE lower(m.title) like lower(?1)
            ORDER BY m.year DESC""")
    Stream<Movie> findByTitle(String title);

}
