package abstraction_and_interfaces.assigment_problems;

public class CityCabFareMeter {
    interface NightService {
        double NIGHT_MULTIPLIER = 1.20;
    }

    abstract static class Cab {
        final String type;
        final double kilometres;
        Cab(String type, double kilometres) { this.type = type; this.kilometres = kilometres; }
        abstract double rate();
        final double dayFare() { return Math.max(100, kilometres * rate()); }
    }

    static class Mini extends Cab {
        Mini(double km) { super("MINI", km); }
        double rate() { return 10; }
    }

    static class Sedan extends Cab implements NightService {
        Sedan(double km) { super("SEDAN", km); }
        double rate() { return 14; }
    }

    static class Suv extends Cab implements NightService {
        Suv(double km) { super("SUV", km); }
        double rate() { return 18; }
    }

    static double completedFare(Cab cab, boolean night) {
        if (night && !(cab instanceof NightService)) {
            return -1;
        }
        return cab.dayFare() * (night ? NightService.NIGHT_MULTIPLIER : 1);
    }

    public static void main(String[] args) {
        Cab[] cabs = {new Mini(8), new Sedan(10), new Suv(20), new Mini(5)};
        boolean[] nights = {false, true, false, true};
        double total = 0;
        for (int index = 0; index < cabs.length; index++) {
            double fare = completedFare(cabs[index], nights[index]);
            if (fare < 0) {
                System.out.println(cabs[index].type + ": night service not available");
            } else {
                total += fare;
                System.out.printf("%s: %.2f%n", cabs[index].type, fare);
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
