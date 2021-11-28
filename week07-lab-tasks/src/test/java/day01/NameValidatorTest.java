package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testNameValidator {

    NameValidator nameValidator = new NameValidator();

    @Test
    void testIsNameValid() {
        boolean result = nameValidator.isNameValid("John Doe");
        assertTrue(result);
    }

    @Test
    void testIsNameValidWithNull() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> nameValidator.isNameValid(null));
        assertEquals("Invalid name: null", iae.getMessage());
    }

    @Test
    void testIsNameValidWithWrongName() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> nameValidator.isNameValid("John"));
        assertEquals("Invalid name: John", iae.getMessage());
    }
}