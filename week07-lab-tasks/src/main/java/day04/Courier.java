package day04;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {
        if (isNewDay(ride)) {
            if (ride.getNumberOfRide() == 1) {
                rides.add(ride);
            } else {
                throw new IllegalArgumentException("Érvénytelen fuvarszám az új napra!");
            }
        } else if (ride.getNumberOfRide() == rides.get(rides.size() - 1).getNumberOfRide() + 1) {
            rides.add(ride);
        } else {
            throw new IllegalArgumentException("Érvénytelen fuvarszám!");
        }
    }

    private boolean isNewDay(Ride ride) {
        if (rides.isEmpty() || rides.get(rides.size() - 1).getDayOfWeek() < ride.getDayOfWeek()) {
            return true;
        } else if (rides.get(rides.size() - 1).getDayOfWeek() == ride.getDayOfWeek()) {
            return false;
        } else {
            throw new IllegalArgumentException("Érvénytelen nap!");
        }
    }

    public List<Ride> getRides() {
        return rides;
    }
}
