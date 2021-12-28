package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testCreate() {
        Human human = new Human("John Doe", 1998);
        assertEquals("John Doe", human.getName());
        assertEquals(1998, human.getYearOfBirth());
    }

    @Test
    void testCreateHumanWithNullName() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Human(null, 1980));
        assertEquals("Name is invalid! null", iae.getMessage());
    }

    @Test
    void testCreateHumanWithEmptyStringName() {
        IllegalArgumentException iaeNameEmptyString = assertThrows(IllegalArgumentException.class,
                () -> new Human("", 1988));
        assertEquals("Name is invalid! ", iaeNameEmptyString.getMessage());
    }

    @Test
    void testCreateHumanWithOneName() {
        IllegalArgumentException iaeOneName = assertThrows(IllegalArgumentException.class,
                () -> new Human("John", 1988));
        assertEquals("Name is invalid! John", iaeOneName.getMessage());
    }

    @Test
    void testCreateHumanWithWrongYearTooOld() {
        IllegalArgumentException iaeTooOld = assertThrows(IllegalArgumentException.class,
                () -> new Human("John Doe", 1900));
        assertEquals("Year of birth is invalid! 1900", iaeTooOld.getMessage());
    }

    @Test
    void testCreateHumanWithWrongYearTooYoung() {
        IllegalArgumentException iaeTooYoung = assertThrows(IllegalArgumentException.class,
                () -> new Human("John Doe", 2022));
        assertEquals("Year of birth is invalid! 2022", iaeTooYoung.getMessage());
    }
}