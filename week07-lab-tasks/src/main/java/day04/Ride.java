package day04;

public class Ride {

    private int dayOfWeek;
    private int numberOfRide;
    private double kms;


    public Ride(int dayOfWeek, int numberOfRide, double kms) {
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            throw new IllegalArgumentException("A hét napja 1 és 7 közötti szám!");
        }
        if (kms <= 0) {
            throw new IllegalArgumentException("A megtett kilóméterek száma pozitív!");
        }
        this.dayOfWeek = dayOfWeek;
        this.numberOfRide = numberOfRide;
        this.kms = kms;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getNumberOfRide() {
        return numberOfRide;
    }

    public double getKms() {
        return kms;
    }
}
