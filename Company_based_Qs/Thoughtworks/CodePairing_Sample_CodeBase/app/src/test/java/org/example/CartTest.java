package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
    Pro Tip: When writing a test case, you should explicitly state what you are expecting and what's the use case for this test.
*/

public class CartTest {
    @Test
    // For Regular customers it should not apply any discount
    void shouldNotApplyAnyDiscountForRegularUser() {
        // create a sample regular user and add a sample product to their cart
        User regularUser = new User("Rahul", "regular");
        Product iphone = new Product("iphone", 100.0);
        Cart cart = new Cart(regularUser);
        cart.addProduct(iphone);

        double actualPrice = cart.applyDiscount();

        assertEquals(100.0, actualPrice);
    }

    @Test
    // For Premium customers it should apply 20% discount
    void shouldApply20PercentDiscountForPremiumUser() {
        // create a sample premium user and add a sample product to their cart
        User premiumUser = new User("Tina", "premium");
        Product iphone = new Product("iphone", 100.0);
        Cart cart = new Cart(premiumUser);
        cart.addProduct(iphone);

        double actualPrice = cart.applyDiscount();

        assertEquals(80.0, actualPrice);
    }

    @Test
    // For Super Premium customers it should apply 30% discount
    void shouldApply30PercentDiscountForSuperPremiumUser() {
        // create a super premium user and add a sample product to their cart
        User superPremiumUser = new User("Anjali", "super premium");
        Product iphone = new Product("iphone", 100.0);
        Cart cart = new Cart(superPremiumUser);
        cart.addProduct(iphone);

        double actualPrice = cart.applyDiscount();

        assertEquals(70.0, actualPrice);
    }

}
