package org.example;

/* 
    CODE PAIRING TASK
    We have received a new requirement from the client that we need to add another User Type "super premium". 
    When these Super Premium users do a purchase using our app, they should get 30% discount. 

    Note:
    Either you can test the code first and then add the new feature, or you can implement the new feature first and then test the code.
    Thoughtworks prefers TDD way, i.e. Test Driven Development, where you write test cases first and then add a new feature.
*/

public class ECommerceApp {
    public static void main(String[] args) {
        // Create a regular user and a premium user
        User regularUser = new User("Alice", "regular");
        User premiumUser = new User("Bob", "premium");

        // NEW: create a super premium user
        User superPremiumUser = new User("Chris", "super premium");

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

        System.out.println("");

        // NEW: create a cart for a super premium user
        Cart superPremiumCart = new Cart(superPremiumUser);
        superPremiumCart.addProduct(product1);
        superPremiumCart.addProduct(product2);
        superPremiumCart.checkout(); // Should apply a 20% discount
    }
}
