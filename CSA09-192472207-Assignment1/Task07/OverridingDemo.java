import java.util.Objects;

class Vehicle {
    private final String vehicleNo;

    Vehicle(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    double calculateFee() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Vehicle No: " + vehicleNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehicle)) return false;
        Vehicle other = (Vehicle) obj;
        return vehicleNo.equals(other.vehicleNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleNo);
    }
}

class Car extends Vehicle {
    Car(String vehicleNo) {
        super(vehicleNo);
    }

    @Override
    double calculateFee() {
        return 30.0;
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String vehicleNo) {
        super(vehicleNo);
    }

    @Override
    double calculateFee() {
        return 10.0;
    }
}

public class OverridingDemo {
    public static void main(String[] args) {
        Car car = new Car("TN01AB1111");
        TwoWheeler twoWheeler = new TwoWheeler("TN02CD2222");

        System.out.println(car);
        System.out.println("Car Fee: Rs " + car.calculateFee());

        System.out.println(twoWheeler);
        System.out.println("Two Wheeler Fee: Rs " + twoWheeler.calculateFee());

        System.out.println(
            new Car("TN01AB1111").equals(new TwoWheeler("TN01AB1111"))
        );
    }
}
