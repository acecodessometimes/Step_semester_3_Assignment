package abstraction_and_interfaces.assigment_problems;

public class MovieTicketCounter {
    abstract static class Ticket {
        static final double CONVENIENCE_FEE = 20;
        final String seatType;
        final int count;
        Ticket(String seatType, int count) { this.seatType = seatType; this.count = count; }
        abstract double pricePerTicket();
        final double amount() { return count * (pricePerTicket() + CONVENIENCE_FEE); }
    }

    static class Regular extends Ticket {
        Regular(int count) { super("REGULAR", count); }
        double pricePerTicket() { return 150; }
    }

    static class Premium extends Ticket {
        Premium(int count) { super("PREMIUM", count); }
        double pricePerTicket() { return 250; }
    }

    static class Recliner extends Ticket {
        Recliner(int count) { super("RECLINER", count); }
        double pricePerTicket() { return 400; }
    }

    public static void main(String[] args) {
        Ticket[] tickets = {new Regular(3), new Premium(2), new Recliner(1)};
        double total = 0;
        for (Ticket ticket : tickets) {
            double amount = ticket.amount();
            total += amount;
            System.out.printf("%s: %.2f%n", ticket.seatType, amount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
