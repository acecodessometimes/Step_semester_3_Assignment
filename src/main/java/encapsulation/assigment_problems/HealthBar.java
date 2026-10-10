package encapsulation.assigment_problems;

public class HealthBar {
    static class Character {
        private int health;
        private final int maximumHealth;

        Character(int maximumHealth) {
            this.maximumHealth = Math.max(0, maximumHealth);
            health = this.maximumHealth;
        }

        void takeDamage(int amount) {
            if (amount > 0) {
                health = Math.max(0, health - amount);
            }
        }

        void heal(int amount) {
            if (amount > 0) {
                health = Math.min(maximumHealth, health + amount);
            }
        }

        int getHealth() {
            return health;
        }
    }

    public static void main(String[] args) {
        Character character = new Character(100);
        character.takeDamage(30);
        System.out.println("health = " + character.getHealth());
        character.heal(50);
        System.out.println("health = " + character.getHealth() + " (capped)");
        character.takeDamage(150);
        System.out.println("health = " + character.getHealth() + " (floored)");
    }
}
