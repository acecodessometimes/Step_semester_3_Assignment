package abstraction_and_interfaces.assigment_problems;

public class ParcelShippingDesk {
    interface Insurable {
        double insurance();
    }

    abstract static class Parcel {
        final String type;
        final double weight;
        final double declaredValue;
        Parcel(String type, double weight, double declaredValue) { this.type = type; this.weight = weight; this.declaredValue = declaredValue; }
        abstract double charge();
    }

    static class Standard extends Parcel {
        Standard(double weight, double value) { super("STANDARD", weight, value); }
        double charge() { return 40 + weight * 10; }
    }

    static class Express extends Parcel implements Insurable {
        Express(double weight, double value) { super("EXPRESS", weight, value); }
        double charge() { return 80 + weight * 15; }
        public double insurance() { return declaredValue * 0.02; }
    }

    static class Fragile extends Parcel implements Insurable {
        Fragile(double weight, double value) { super("FRAGILE", weight, value); }
        double charge() { return 40 + weight * 10 + 50; }
        public double insurance() { return declaredValue * 0.02; }
    }

    public static void main(String[] args) {
        Parcel[] parcels = {new Standard(3, 500), new Express(2, 1000), new Fragile(4, 2000)};
        double grandTotal = 0;
        for (Parcel parcel : parcels) {
            double charge = parcel.charge();
            double insurance = parcel instanceof Insurable ? ((Insurable) parcel).insurance() : 0;
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", parcel.type, charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
