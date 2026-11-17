class ParkingTicket {
    int ticketNo;
    String vehicleNo;

    // Default constructor uses constructor chaining.
    ParkingTicket() {
        this(1001, "Not Assigned");
    }

    // Parameterized constructor.
    ParkingTicket(int ticketNo, String vehicleNo) {
        this.ticketNo = ticketNo;
        this.vehicleNo = vehicleNo;
    }

    // Copy constructor.
    ParkingTicket(ParkingTicket ticket) {
        this(ticket.ticketNo, ticket.vehicleNo);
    }

    void display() {
        System.out.println("Ticket No: " + ticketNo);
        System.out.println("Vehicle No: " + vehicleNo);
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        ParkingTicket t1 = new ParkingTicket(1002, "TN01AB1111");
        ParkingTicket t2 = new ParkingTicket(t1);

        t1.display();
        t2.display();
    }
}
