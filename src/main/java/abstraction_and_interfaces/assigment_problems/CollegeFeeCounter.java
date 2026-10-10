package abstraction_and_interfaces.assigment_problems;

public class CollegeFeeCounter {
    interface BusUser {
        double TRANSPORT_FEE = 12000;
    }

    abstract static class Student {
        final String name;
        Student(String name) { this.name = name; }
        abstract double tuitionAndHousing();
        final double totalFee() { return tuitionAndHousing() + (this instanceof BusUser ? BusUser.TRANSPORT_FEE : 0); }
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) { super(name); }
        double tuitionAndHousing() { return 40000; }
    }

    static class Hosteller extends Student {
        Hosteller(String name) { super(name); }
        double tuitionAndHousing() { return 40000 + 60000; }
    }

    static class Scholar extends Student implements BusUser {
        Scholar(String name) { super(name); }
        double tuitionAndHousing() { return 20000; }
    }

    public static void main(String[] args) {
        Student[] students = {new DayScholar("Asha"), new Hosteller("Ravi"), new Scholar("Neha")};
        double total = 0;
        for (Student student : students) {
            double fee = student.totalFee();
            total += fee;
            System.out.printf("%s: %.2f%n", student.name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}
