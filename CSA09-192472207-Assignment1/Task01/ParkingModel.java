class Vehicle {
    String vehicleNo;
    String vehicleType;

    Vehicle(String vehicleNo, String vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    void displayVehicle() {
        System.out.println("Vehicle No: " + vehicleNo);
        System.out.println("Vehicle Type: " + vehicleType);
    }
}

class ParkingSlot {
    int slotNo;
    boolean isOccupied;

    ParkingSlot(int slotNo) {
        this.slotNo = slotNo;
        this.isOccupied = false;
    }

    boolean parkVehicle() {
        if (!isOccupied) {
            isOccupied = true;
            return true;
        }
        return false;
    }
}

class ParkingTicket {
    static int ticketCounter = 1000;
    int ticketNo;
    String vehicleNo;

    ParkingTicket(String vehicleNo) {
        ticketCounter++;
        this.ticketNo = ticketCounter;
        this.vehicleNo = vehicleNo;
    }

    void displayTicket() {
        System.out.println("Ticket No: " + ticketNo);
        System.out.println("Vehicle No: " + vehicleNo);
    }
}

public class ParkingModel {
    public static void main(String[] args) {
        Vehicle v = new Vehicle("TN01AB1111", "Car");
        ParkingSlot s = new ParkingSlot(1);
        ParkingTicket t = new ParkingTicket(v.vehicleNo);

        v.displayVehicle();

        if (s.parkVehicle()) {
            System.out.println("Slot Allocated: " + s.slotNo);
        }

        t.displayTicket();
    }
}
