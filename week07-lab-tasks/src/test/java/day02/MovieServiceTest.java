package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    @Test
    void testMovieService() {
        MovieService movieService = new MovieService(Paths.get("src/test/resources/movies.csv"));
        assertEquals(5, movieService.getMovies().size());
        assertEquals("Star Wars", movieService.getMovies().get(2).getTitle());
        assertEquals(1977, movieService.getMovies().get(2).getYearOfProduction());
        assertEquals("George Lucas", movieService.getMovies().get(2).getDirector());
    }
    
    @Test
    void testFillMoviesFileNotFound() {
        IllegalStateException ise = assertThrows(IllegalStateException.class,
            () -> new MovieService(Paths.get("movies.txt")));
        assertEquals("Can't read file!", ise.getMessage());
        assertEquals(NoSuchFileException.class, ise.getCause().getClass());
    }
}