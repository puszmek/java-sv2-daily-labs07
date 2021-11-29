package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RideTest {

    Ride ride;

    @Test
    void testCreateRide() {
        ride = new Ride(4, 3, 9);
        assertEquals(4, ride.getDayOfWeek());
        assertEquals(3, ride.getNumberOfRide());
        assertEquals(9, ride.getKms());
    }

    @Test
    void testCreateRideIllegalDay() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> ride = new Ride(8, 4, 10));
        assertEquals("A hét napja 1 és 7 közötti szám!", iae.getMessage());
    }

    @Test
    void testCreateRideIllegalKm() {
        IllegalArgumentException iae0 = assertThrows(IllegalArgumentException.class,
                () -> ride = new Ride(5, 6, 0));
        assertEquals("A megtett kilóméterek száma pozitív!", iae0.getMessage());
        IllegalArgumentException  iae = assertThrows(IllegalArgumentException.class,
                () -> ride = new Ride(5, 6, -5));
        assertEquals("A megtett kilóméterek száma pozitív!", iae.getMessage());
    }
}