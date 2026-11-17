import java.util.HashMap;
import java.util.Map;

abstract class Vehicle {
    private final String regNo;

    Vehicle(String regNo) {
        if (regNo == null || regNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number is required");
        }
        this.regNo = regNo;
    }

    String getRegNo() {
        return regNo;
    }

    abstract double getRatePerHour();
}

class Car extends Vehicle {
    Car(String regNo) { super(regNo); }

    @Override
    double getRatePerHour() { return 30.0; }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String regNo) { super(regNo); }

    @Override
    double getRatePerHour() { return 10.0; }
}

class ElectricCar extends Vehicle {
    ElectricCar(String regNo) { super(regNo); }

    @Override
    double getRatePerHour() { return 30.0; }
}

class ParkingTicket {
    private static int counter = 1000;

    final int ticketNo;
    final Vehicle vehicle;
    final int floor;
    final int slot;
    final boolean monthlyPass;

    ParkingTicket(Vehicle vehicle, int floor, int slot, boolean monthlyPass) {
        this.ticketNo = ++counter;
        this.vehicle = vehicle;
        this.floor = floor;
        this.slot = slot;
        this.monthlyPass = monthlyPass;
    }
}

public class SmartParkingSystem {
    private final String[][] slots = {
        new String[3],
        new String[2]
    };

    private final Map<String, ParkingTicket> activeTickets = new HashMap<>();

    public void parkVehicle(Vehicle vehicle, boolean monthlyPass) {
        String regNo = vehicle.getRegNo();

        if (activeTickets.containsKey(regNo)) {
            System.out.println("Duplicate Registration: " + regNo);
            return;
        }

        for (int floor = 0; floor < slots.length; floor++) {
            for (int slot = 0; slot < slots[floor].length; slot++) {
                if (slots[floor][slot] == null) {
                    slots[floor][slot] = regNo;
                    ParkingTicket ticket =
                        new ParkingTicket(vehicle, floor, slot, monthlyPass);
                    activeTickets.put(regNo, ticket);

                    System.out.println("Vehicle Parked: " + regNo);
                    System.out.println("Ticket Number: " + ticket.ticketNo);
                    System.out.println("Floor: " + floor + ", Slot: " + slot);
                    return;
                }
            }
        }

        System.out.println("Parking Full");
    }

    public void exitVehicle(String regNo, int minutes) {
        if (minutes < 0) {
            System.out.println("Invalid parking duration");
            return;
        }

        ParkingTicket ticket = activeTickets.get(regNo);
        if (ticket == null) {
            System.out.println("Vehicle Not Found: " + regNo);
            return;
        }

        int billableHours = (minutes + 59) / 60;
        double fee = ticket.monthlyPass
                ? 0.0
                : billableHours * ticket.vehicle.getRatePerHour();

        slots[ticket.floor][ticket.slot] = null;
        activeTickets.remove(regNo);

        System.out.println("Vehicle Exited: " + regNo);
        System.out.println("Parking Fee: Rs " + fee);
    }

    public static void main(String[] args) {
        SmartParkingSystem parking = new SmartParkingSystem();

        parking.parkVehicle(new Car("TN01AB1111"), false);
        parking.parkVehicle(new TwoWheeler("TN02CD2222"), true);
        parking.parkVehicle(new ElectricCar("TN03EF3333"), false);
        parking.parkVehicle(new Car("TN01AB1111"), false);

        parking.exitVehicle("TN01AB1111", 130);
        parking.exitVehicle("TN02CD2222", 60);
        parking.exitVehicle("TN03EF3333", 60);
        parking.exitVehicle("TN05XX9999", 60);
    }
}
