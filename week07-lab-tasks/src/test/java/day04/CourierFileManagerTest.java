package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CourierFileManagerTest {

    CourierFileManager courierFileManager = new CourierFileManager();

    @Test
    void testCourierFileManager() {
        Path path = Paths.get("src/test/resources/rides.txt");
        Courier courier = courierFileManager.createCourierByFile(path);
        assertEquals(6, courier.getRides().size());
    }

    @Test
    void testCourierFileManagerFileNotFound() {
        Path path = Paths.get("src/test/resources/rides_.txt");
        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> courierFileManager.createCourierByFile(path));
        assertEquals("Hiba a fájl beolvasásakor!", ise.getMessage());
    }

    @Test
    void testCourierFileManagerIllegalFormat() {
        Path path = Paths.get("src/test/resources/anotherrides.txt");
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> courierFileManager.createCourierByFile(path));
        assertEquals("Hibás formátum!", iae.getMessage());
    }
}