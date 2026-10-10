package polymorphism.assigment_problems;

public class HostelElectricityBill {
    abstract static class Room {
        final String type;
        final int units;

        Room(String type, int units) {
            this.type = type;
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) { super("SINGLE", units); }
        double calculateBill() { return units * 8.0; }
    }

    static class SharedRoom extends Room {
        final int occupants;
        SharedRoom(int units, int occupants) { super("SHARED", units); this.occupants = occupants; }
        double calculateBill() { return units * 6.0 / occupants; }
    }

    static class AcRoom extends Room {
        AcRoom(int units) { super("AC", units); }
        double calculateBill() { return units * 10.0 + 200; }
    }

    public static void main(String[] args) {
        Room[] rooms = {new SingleRoom(120), new SharedRoom(150, 3), new AcRoom(100)};
        double total = 0;
        for (Room room : rooms) {
            double bill = room.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", room.type, bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
