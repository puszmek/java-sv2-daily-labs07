package day05;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product = new Product("apple", LocalDate.of(2021, 6, 14), 585);

    @Test
    void testCreate() {
        assertEquals("apple", product.getName());
        assertEquals(LocalDate.of(2021, 6, 14), product.getSellDate());
        assertEquals(585, product.getPrice());
    }

    @Test
    void testToString() {
        assertEquals("apple;2021-06-14;585", product.toString());
    }
}