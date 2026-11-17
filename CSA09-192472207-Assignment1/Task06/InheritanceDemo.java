class Vehicle {
    String vehicleNo;

    Vehicle(String vehicleNo) {
        this.vehicleNo = vehicleNo;
        System.out.println("Vehicle Constructor");
    }

    void display() {
        System.out.println("Vehicle No: " + vehicleNo);
    }
}

class Car extends Vehicle {
    Car(String vehicleNo) {
        super(vehicleNo);
        System.out.println("Car Constructor");
    }
}

class ElectricCar extends Car {
    ElectricCar(String vehicleNo) {
        super(vehicleNo);
        System.out.println("ElectricCar Constructor");
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String vehicleNo) {
        super(vehicleNo);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar("TN01EV1234");
        electricCar.display();

        TwoWheeler twoWheeler = new TwoWheeler("TN02TW5678");
        twoWheeler.display();
    }
}
