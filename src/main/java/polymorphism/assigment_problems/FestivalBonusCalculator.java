package polymorphism.assigment_problems;

public class FestivalBonusCalculator {
    abstract static class Employee {
        final String name;
        final double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        abstract double calculateBonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String name, double salary) { super(name, salary); }
        double calculateBonus() { return monthlySalary * 0.10; }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String name, double salary) { super(name, salary); }
        double calculateBonus() { return monthlySalary * 0.05; }
    }

    static class Intern extends Employee {
        Intern(String name, double salary) { super(name, salary); }
        double calculateBonus() { return 2000; }
    }

    public static void main(String[] args) {
        Employee[] employees = {
            new FullTimeEmployee("Asha", 50000),
            new PartTimeEmployee("Ravi", 30000),
            new Intern("Neha", 15000)
        };
        double total = 0;
        for (Employee employee : employees) {
            double bonus = employee.calculateBonus();
            total += bonus;
            System.out.printf("%s: %.2f%n", employee.name, bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
