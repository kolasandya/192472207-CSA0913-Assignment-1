import java.util.Scanner;

public class ParkingArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] slotsPerFloor = {3, 2, 4};
        String[][] slots = new String[slotsPerFloor.length][];

        for (int i = 0; i < slotsPerFloor.length; i++) {
            slots[i] = new String[slotsPerFloor[i]];
        }

        System.out.print("Enter floor number (0-" + (slots.length - 1) + "): ");
        int floor = sc.nextInt();

        System.out.print("Enter slot number (0-based): ");
        int slot = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter vehicle number: ");
        String vehicleNo = sc.nextLine();

        if (floor >= 0 && floor < slots.length &&
            slot >= 0 && slot < slots[floor].length) {

            if (slots[floor][slot] == null) {
                slots[floor][slot] = vehicleNo;
                System.out.println("Vehicle Parked Successfully");
            } else {
                System.out.println("Slot Already Occupied");
            }
        } else {
            System.out.println("Invalid Floor or Slot");
        }

        sc.close();
    }
}
