package parking.model;

public class ParkingSlot {
    private int slotNo;
    private boolean occupied;

    public ParkingSlot(int slotNo) {
        setSlotNo(slotNo);
        occupied = false;
    }

    public void setSlotNo(int slotNo) {
        if (slotNo <= 0) {
            throw new IllegalArgumentException("Invalid slot number");
        }
        this.slotNo = slotNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void park() {
        if (occupied) {
            System.out.println("Slot already occupied");
        } else {
            occupied = true;
            System.out.println("Vehicle parked");
        }
    }
}
