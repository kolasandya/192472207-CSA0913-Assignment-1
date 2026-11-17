package parking.app;

import parking.model.ParkingSlot;

public class Main {
    public static void main(String[] args) {
        ParkingSlot slot = new ParkingSlot(1);

        slot.park();

        System.out.println("Slot Number: " + slot.getSlotNo());
        System.out.println("Occupied: " + slot.isOccupied());

        Integer ticketNumber = 100;
        int value = ticketNumber; // unboxing
        System.out.println("Ticket Number: " + value);
    }
}
