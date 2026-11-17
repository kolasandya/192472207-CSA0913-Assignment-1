import java.time.LocalTime;

abstract class Vehicle {
    private final String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    String getRegNo() {
        return regNo;
    }

    abstract double calculateFee(int parkingMinutes, LocalTime entryTime);
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int parkingMinutes, LocalTime entryTime) {
        int hours = (parkingMinutes + 59) / 60;
        return hours * 30.0;
    }
}

class EBike extends Vehicle {
    private static final double FLAT_FEE = 20.0;

    EBike(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int parkingMinutes, LocalTime entryTime) {
        return FLAT_FEE;
    }
}

class DeliveryVan extends Vehicle {
    DeliveryVan(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int parkingMinutes, LocalTime entryTime) {
        if (parkingMinutes < 0) {
            throw new IllegalArgumentException("Parking time cannot be negative");
        }

        // Assumption: the vehicle exits on the same day.
        // Charge the double-car rate only for minutes overlapping 09:00-17:00.
        int totalFee = 0;
        LocalTime exitTime = entryTime.plusMinutes(parkingMinutes);
        LocalTime windowStart = LocalTime.of(9, 0);
        LocalTime windowEnd = LocalTime.of(17, 0);

        LocalTime start = entryTime.isAfter(windowStart) ? entryTime : windowStart;
        LocalTime end = exitTime.isBefore(windowEnd) ? exitTime : windowEnd;

        int daytimeMinutes = 0;
        if (end.isAfter(start)) {
            daytimeMinutes = (int) java.time.Duration.between(start, end).toMinutes();
        }

        int otherMinutes = parkingMinutes - daytimeMinutes;
        int daytimeHours = (daytimeMinutes + 59) / 60;
        int otherHours = (otherMinutes + 59) / 60;

        totalFee = daytimeHours * 60 + otherHours * 30;
        return totalFee;
    }
}

class VisitorPass {
    private final String visitorName;
    private final LocalTime issueTime;

    VisitorPass(String visitorName, LocalTime issueTime) {
        this.visitorName = visitorName;
        this.issueTime = issueTime;
    }

    boolean isValidAt(LocalTime checkTime) {
        // Demonstration assumes the pass is used on the same calendar day.
        return !checkTime.isBefore(issueTime);
    }

    void displayPass() {
        System.out.println("Visitor: " + visitorName);
        System.out.println("One-day visitor pass issued at: " + issueTime);
    }
}

public class DesignChallenge {
    public static void main(String[] args) {
        int[] slotsPerFloor = {10, 15, 20, 25, 30};
        String[][] parking = new String[slotsPerFloor.length][];

        for (int floor = 0; floor < slotsPerFloor.length; floor++) {
            parking[floor] = new String[slotsPerFloor[floor]];
        }

        Vehicle[] vehicles = {
            new Car("TN01CAR1111"),
            new EBike("TN02EB2222"),
            new DeliveryVan("TN03DV3333")
        };

        System.out.println("Car Fee: Rs " +
            vehicles[0].calculateFee(120, LocalTime.of(10, 0)));
        System.out.println("E-Bike Fee: Rs " +
            vehicles[1].calculateFee(120, LocalTime.of(10, 0)));
        System.out.println("Delivery Van Fee: Rs " +
            vehicles[2].calculateFee(120, LocalTime.of(10, 0)));

        VisitorPass pass =
            new VisitorPass("Campus Visitor", LocalTime.of(9, 0));
        pass.displayPass();

        System.out.println("Pass valid at 14:00: " +
            pass.isValidAt(LocalTime.of(14, 0)));
        System.out.println("Total Floors: " + parking.length);
    }
}
