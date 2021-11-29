package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    Courier courier = new Courier();

    @Test
    void testEmptyCourier() {
        assertNotNull(courier.getRides());
        assertEquals(0, courier.getRides().size());
    }

    @Test
    void testAddValidRides() {
        courier.addRide(new Ride(1, 1, 12));
        courier.addRide(new Ride(1, 2, 11));
        courier.addRide(new Ride(2, 1, 10));
        courier.addRide(new Ride(4, 1, 19));
        courier.addRide(new Ride(4, 2, 5));
        courier.addRide(new Ride(4, 3, 9));
        assertEquals(6, courier.getRides().size());
        assertEquals(4, courier.getRides().get(3).getDayOfWeek());
        assertEquals(3, courier.getRides().get(5).getNumberOfRide());
        assertEquals(10, courier.getRides().get(2).getKms());
    }

    @Test
    void testAddInvalidFirstRide() {
        Ride wrongRide = new Ride(6, 2, 5);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(wrongRide));
        assertEquals("Érvénytelen fuvarszám az új napra!", iae.getMessage());
    }

    @Test
    void testAddInvalidDayOfWeekRide() {
        courier.addRide(new Ride(7, 1, 9));
        Ride wrongRide = new Ride(5, 1, 7);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(wrongRide));
        assertEquals("Érvénytelen nap!", iae.getMessage());
    }

    @Test
    void testAddInvalidNewDayOfWeekRide() {
        courier.addRide(new Ride(5, 1, 9));
        Ride wrongRide = new Ride(7, 2, 7);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(wrongRide));
        assertEquals("Érvénytelen fuvarszám az új napra!", iae.getMessage());
    }

    @Test
    void testAddInvalidNumberOfRide() {
        courier.addRide(new Ride(5, 1, 9));
        Ride wrongRide = new Ride(5, 3, 7);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> courier.addRide(wrongRide));
        assertEquals("Érvénytelen fuvarszám!", iae.getMessage());
    }
}