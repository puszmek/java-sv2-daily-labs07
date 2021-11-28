package day01;

import java.time.LocalDate;

public class YearOfBirthValidator {

    public boolean isYearOfBirthValid(int yearOfBirth) {
        if (LocalDate.now().getYear() - yearOfBirth > 120 || yearOfBirth > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid year: " + yearOfBirth);
        }
        return true;
    }
}
