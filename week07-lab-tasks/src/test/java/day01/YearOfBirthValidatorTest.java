package day01;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class testYearOfBirthValidator {

    YearOfBirthValidator yearOfBirthValidator = new YearOfBirthValidator();

    @Test
    void testIsYearOfBirthValid() {
        assertTrue(yearOfBirthValidator.isYearOfBirthValid(1901));
        assertTrue(yearOfBirthValidator.isYearOfBirthValid(LocalDate.now().getYear() - 120));
        assertTrue(yearOfBirthValidator.isYearOfBirthValid(LocalDate.now().getYear()));

    }

    @Test
    void testIsYearOfBirthValidWithWrongParameter() {
        IllegalArgumentException iaeTooOld = assertThrows(IllegalArgumentException.class,
                () -> yearOfBirthValidator.isYearOfBirthValid(1900));
        assertEquals("Invalid year: 1900", iaeTooOld.getMessage());
        IllegalArgumentException iaeTooYoung = assertThrows(IllegalArgumentException.class,
                () -> yearOfBirthValidator.isYearOfBirthValid(2022));
        assertEquals("Invalid year: 2022", iaeTooYoung.getMessage());
    }
}