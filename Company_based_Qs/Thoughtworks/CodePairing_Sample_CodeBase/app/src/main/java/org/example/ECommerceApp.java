package org.example;

public class ECommerceApp {
    public static void main(String[] args) {
        // Create a regular user and a premium user
        User regularUser = new User("Alice", "regular");
        User premiumUser = new User("Bob", "premium");

        // Create some products
        Product product1 = new Product("Laptop", 1000);
        Product product2 = new Product("Headphones", 200);

        // Create a cart for a regular user
        Cart regularCart = new Cart(regularUser);
        regularCart.addProduct(product1);
        regularCart.addProduct(product2);
        regularCart.checkout(); // Should not apply a discount

        System.out.println("");

        // Create a cart for a premium user
        Cart premiumCart = new Cart(premiumUser);
        premiumCart.addProduct(product1);
        premiumCart.addProduct(product2);
        premiumCart.checkout(); // Should apply a 20% discount
    }
}
