package polymorphism.assigment_problems;

public class CampusParkingChargeCalculator {
    abstract static class ParkedVehicle {
        final String type;
        final int hours;

        ParkedVehicle(String type, int hours) {
            this.type = type;
            this.hours = hours;
        }

        abstract double calculateCharge();
    }

    static class Bike extends ParkedVehicle {
        Bike(int hours) { super("BIKE", hours); }
        double calculateCharge() { return hours * 10.0; }
    }

    static class Car extends ParkedVehicle {
        Car(int hours) { super("CAR", hours); }
        double calculateCharge() { return 30 + Math.max(0, hours - 1) * 20.0; }
    }

    static class Truck extends ParkedVehicle {
        Truck(int hours) { super("TRUCK", hours); }
        double calculateCharge() { return Math.max(100, hours * 50.0); }
    }

    public static void main(String[] args) {
        ParkedVehicle[] vehicles = {new Bike(3), new Car(4), new Truck(1), new Car(1)};
        double total = 0;
        for (ParkedVehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();
            total += charge;
            System.out.printf("%s: %.2f%n", vehicle.type, charge);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
