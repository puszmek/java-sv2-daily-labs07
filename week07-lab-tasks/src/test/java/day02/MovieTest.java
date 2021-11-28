package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void testCreateMovie() {
        Movie movie = new Movie("Titanic", 1997, "James Cameron");
        assertEquals("Titanic", movie.getTitle());
        assertEquals(1997, movie.getYearOfProduction());
        assertEquals("James Cameron", movie.getDirector());
    }
}