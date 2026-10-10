package polymorphism.assigment_problems;

public class CanteenBillingCounter {
    abstract static class CustomerBill {
        final String type;
        final double amount;

        CustomerBill(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        abstract double calculateFinalAmount();
    }

    static class StudentBill extends CustomerBill {
        StudentBill(double amount) { super("STUDENT", amount); }
        double calculateFinalAmount() { return amount * 0.90; }
    }

    static class StaffBill extends CustomerBill {
        StaffBill(double amount) { super("STAFF", amount); }
        double calculateFinalAmount() { return amount * 0.95; }
    }

    static class GuestBill extends CustomerBill {
        GuestBill(double amount) { super("GUEST", amount); }
        double calculateFinalAmount() { return amount + 10; }
    }

    public static void main(String[] args) {
        CustomerBill[] bills = {new StudentBill(200), new StaffBill(300), new GuestBill(150)};
        double total = 0;
        for (CustomerBill bill : bills) {
            double value = bill.calculateFinalAmount();
            total += value;
            System.out.printf("%s: %.2f%n", bill.type, value);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
