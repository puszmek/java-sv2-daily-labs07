package day01;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

//    @Test
//    void testCreateHumanWithNullName() {
//        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Human(null, minYear));
//        assertEquals("Name cannot be null!", iae.getMessage());
//    }

    @Test
    void testCreate() {
        Human human = new Human("John Doe", 1998);
        assertEquals("John Doe", human.getName());
        assertEquals(1998, human.getYearOfBrith());
    }

    @Test
    void testCreateHumanWithWrongName() {
        IllegalArgumentException iaeNameNull = assertThrows(IllegalArgumentException.class,
                () -> new Human(null, 1988));
        assertEquals("Invalid name: null", iaeNameNull.getMessage());
        IllegalArgumentException iaeNameEmptyString = assertThrows(IllegalArgumentException.class,
                () -> new Human("", 1988));
        assertEquals("Invalid name: ", iaeNameEmptyString.getMessage());
        IllegalArgumentException iaeOneName = assertThrows(IllegalArgumentException.class,
                () -> new Human("John", 1988));
        assertEquals("Invalid name: John", iaeOneName.getMessage());
    }

    @Test
    void testCreateHumanWithWrongYear() {
        IllegalArgumentException iaeTooOld = assertThrows(IllegalArgumentException.class,
                () -> new Human("John Doe", 1900));
        assertEquals("Invalid year: 1900", iaeTooOld.getMessage());
        IllegalArgumentException iaeTooYoung = assertThrows(IllegalArgumentException.class,
                () -> new Human("John Doe", 2022));
        assertEquals("Invalid year: 2022", iaeTooYoung.getMessage());
    }
}