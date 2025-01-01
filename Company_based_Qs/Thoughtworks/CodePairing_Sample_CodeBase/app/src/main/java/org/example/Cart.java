package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> products;
    private final User user;

    public Cart(User user) {
        this.products = new ArrayList<>();
        this.user = user;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to the cart.");
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public double applyDiscount() {
        double total = calculateTotal();
        if (user.getUserType().equalsIgnoreCase("premium")) {
            System.out.println("Applying 20% discount for premium user.");
            return total * 0.80;
        } else {
            System.out.println("No discount for regular user.");
            return total;
        }
    }

    public void checkout() {
        double total = applyDiscount();
        System.out.println("Total after discount: $" + total);
    }

}
