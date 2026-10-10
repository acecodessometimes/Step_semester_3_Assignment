package polymorphism.assigment_problems;

import java.time.LocalDate;

public class StreamingPlanRenewalReminder {
    abstract static class Subscription {
        final String name;
        final LocalDate startDate;

        Subscription(String name, String startDate) {
            this.name = name;
            this.startDate = LocalDate.parse(startDate);
        }

        abstract int validityDays();

        LocalDate renewalDate() {
            return startDate.plusDays(validityDays());
        }
    }

    static class Basic extends Subscription {
        Basic(String name, String date) { super(name, date); }
        int validityDays() { return 30; }
    }

    static class Standard extends Subscription {
        Standard(String name, String date) { super(name, date); }
        int validityDays() { return 90; }
    }

    static class Premium extends Subscription {
        Premium(String name, String date) { super(name, date); }
        int validityDays() { return 365; }
    }

    public static void main(String[] args) {
        Subscription[] subscriptions = {
            new Basic("Asha", "2024-01-15"),
            new Standard("Ravi", "2024-02-01"),
            new Premium("Neha", "2024-03-10"),
            new Basic("Kiran", "2024-12-20")
        };
        for (Subscription subscription : subscriptions) {
            System.out.println(subscription.name + ": " + subscription.renewalDate());
        }
    }
}
