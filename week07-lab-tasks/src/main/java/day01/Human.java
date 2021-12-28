package day01;

import java.time.LocalDate;

public class Human {

    private String name;
    private int yearOfBirth;

    public Human(String name, int yearOfBirth) {
        if (isYearOfBirthValid(yearOfBirth) && isNameValid(name)) {
            this.name = name;
            this.yearOfBirth = yearOfBirth;
        }
    }

    private boolean isYearOfBirthValid(int yearOfBirth) {
        if ((LocalDate.now().getYear() - yearOfBirth) > 120 || yearOfBirth > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Year of birth is invalid! " + yearOfBirth);
        }
        return true;
    }

    private boolean isNameValid(String name) {
        if (name == null || !name.trim().contains(" ")) {
            throw new IllegalArgumentException("Name is invalid! " + name);
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
