package classes_and_objects.assigment_problems;

public class EmployeeProfileCreation {
    static class Employee {
        String empId;
        String empName;
        double salary;
        boolean isIntern;

        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            isIntern = false;
        }

        public Employee(String empId, String empName) {
            this(empId, empName, 0);
            isIntern = true;
        }

        void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
        }
    }

    public static void main(String[] args) {
        new Employee("E-101", "Divya", 65000).printProfile();
        new Employee("E-102", "Arjun").printProfile();
    }
}
