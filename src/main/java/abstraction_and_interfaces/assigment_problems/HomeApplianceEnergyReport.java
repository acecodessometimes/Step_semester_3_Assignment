package abstraction_and_interfaces.assigment_problems;

public class HomeApplianceEnergyReport {
    interface SaverMode {
        double SAVER_FACTOR = 0.75;
    }

    abstract static class Appliance {
        final String type;
        final double hours;
        Appliance(String type, double hours) { this.type = type; this.hours = hours; }
        abstract double powerWatts();
        final double units(boolean saver) { return powerWatts() * hours / 1000 * (saver ? SaverMode.SAVER_FACTOR : 1); }
    }

    static class Fridge extends Appliance {
        Fridge(double hours) { super("FRIDGE", hours); }
        double powerWatts() { return 150; }
    }

    static class AirConditioner extends Appliance implements SaverMode {
        AirConditioner(double hours) { super("AC", hours); }
        double powerWatts() { return 1500; }
    }

    static class Television extends Appliance {
        Television(double hours) { super("TV", hours); }
        double powerWatts() { return 100; }
    }

    static class Washer extends Appliance implements SaverMode {
        Washer(double hours) { super("WASHER", hours); }
        double powerWatts() { return 500; }
    }

    public static void main(String[] args) {
        Appliance[] appliances = {new Fridge(24), new AirConditioner(8), new Television(5), new Washer(2)};
        boolean[] saverRequested = {false, true, false, true};
        double totalCost = 0;
        for (int index = 0; index < appliances.length; index++) {
            Appliance appliance = appliances[index];
            boolean saver = saverRequested[index];
            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(appliance.type + ": saver mode not supported");
                continue;
            }
            double units = appliance.units(saver);
            double cost = units * 8;
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.type, units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
