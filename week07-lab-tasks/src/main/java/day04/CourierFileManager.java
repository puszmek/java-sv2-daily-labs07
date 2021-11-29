package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CourierFileManager {

    public Courier createCourierByFile(Path path) {
        Courier courier = new Courier();
        List<String> contents;
        try {
            contents = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Hiba a fájl beolvasásakor!", ioe);
        }
        for (String line : contents) {
            try {
                String[] parts = line.split(" ");
                int dayOfWeek = Integer.parseInt(parts[0]);
                int numberOfRide = Integer.parseInt(parts[1]);
                int kms = Integer.parseInt(parts[2]);
                courier.addRide(new Ride(dayOfWeek, numberOfRide, kms));
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Hibás formátum!", nfe);
            }
        }
        return courier;
    }
}
