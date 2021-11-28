package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    Store store = new Store();

    @TempDir
    File temporaryFolder;

    @BeforeEach
    void init() {
        store.addProduct(new Product("apple", LocalDate.of(2021, 5, 14), 600));
        store.addProduct(new Product("pear", LocalDate.of(2021, 5, 16), 800));
        store.addProduct(new Product("apple", LocalDate.of(2021, 6, 24), 550));
    }

    @Test
    void testAddProduct() {
        Store store = new Store();
        assertEquals(0, store.getSoldProducts().size());
        store.addProduct(new Product("peach", LocalDate.of(2021, 6, 10), 860));
        assertEquals(1, store.getSoldProducts().size());
    }

    @Test
    void testWriteToFileByMonth() throws IOException {
        Path path = temporaryFolder.toPath().resolve("result.txt");
        Path resultPath = store.writeToFileByMonth(Month.MAY, path);
        List<String> result = Files.readAllLines(path);
        assertEquals("pear", result.get(1).split(";")[0]);
        assertEquals(2, result.size());
        assertEquals("soldProducts_MAY.csv", resultPath.toString());
    }
}