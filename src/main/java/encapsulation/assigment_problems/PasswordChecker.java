package encapsulation.assigment_problems;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        }
        if (password.length() < 10) {
            return "Medium";
        }
        return "Strong";
    }

    public static void main(String[] args) {
        PasswordChecker first = new PasswordChecker("abcd");
        PasswordChecker second = new PasswordChecker("abcdefghij");
        System.out.println(first.getStrength());
        System.out.println(second.getStrength());
    }
}
