package encapsulation.assigment_problems;

public class ShoppingCart {
    static class Cart {
        private final double[] prices;
        private int itemCount;
        private final String cartId;

        Cart(String cartId, int maximumItems) {
            this.cartId = cartId;
            prices = new double[Math.max(0, maximumItems)];
        }

        void addItem(double price) {
            if (price >= 0 && itemCount < prices.length) {
                prices[itemCount++] = price;
            }
        }

        double getTotal() {
            double total = 0;
            for (int index = 0; index < itemCount; index++) {
                total += prices[index];
            }
            return total;
        }

        int getItemCount() {
            return itemCount;
        }

        String getCartId() {
            return cartId;
        }
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.printf("%.0f%n", cart.getTotal());
        System.out.println(cart.getItemCount());
    }
}
