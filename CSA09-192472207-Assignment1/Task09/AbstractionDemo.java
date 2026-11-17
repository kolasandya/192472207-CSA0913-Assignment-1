interface Chargeable {
    double chargingFee(int units);

    default void chargingMessage() {
        System.out.println("Vehicle is charging");
    }

    static void displayRate() {
        System.out.println("Charging Rate: Rs 12 per unit");
    }
}

abstract class Vehicle {
    String vehicleNo;

    Vehicle(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    abstract double calculateFee();
}

class ElectricCar extends Vehicle implements Chargeable {
    ElectricCar(String vehicleNo) {
        super(vehicleNo);
    }

    @Override
    double calculateFee() {
        return 60;
    }

    @Override
    public double chargingFee(int units) {
        return units * 12;
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        ElectricCar car = new ElectricCar("TN01EV1234");

        System.out.println("Vehicle No: " + car.vehicleNo);
        System.out.println("Parking Fee: Rs " + car.calculateFee());

        car.chargingMessage();
        System.out.println("Charging Fee: Rs " + car.chargingFee(5));
        Chargeable.displayRate();
    }
}
