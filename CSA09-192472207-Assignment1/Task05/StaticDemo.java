class ParkingTicket {
    static int ticketCounter = 1000;

    int ticketNo;
    String vehicleNo;

    ParkingTicket(String vehicleNo) {
        ticketCounter++;
        this.ticketNo = ticketCounter;
        this.vehicleNo = vehicleNo;
    }

    static void displayCounter() {
        System.out.println("Total Tickets: " + ticketCounter);
    }

    void display() {
        System.out.println("Ticket No: " + ticketNo);
        System.out.println("Vehicle No: " + vehicleNo);
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        ParkingTicket t1 = new ParkingTicket("TN01AB1111");
        ParkingTicket t2 = new ParkingTicket("TN02CD2222");

        t1.display();
        t2.display();
        ParkingTicket.displayCounter();

        // Removing these references makes the objects eligible for garbage collection
        // if no other references point to them.
        t1 = null;
        t2 = null;
        System.out.println("Ticket references released");
    }
}
