package nbu.multithreadingProject.store;

import java.util.Map;

public class Store {
    private final Map<String, Product> products;

    public Store(Map<String, Product> products) {
        this.products = products;
    }

    public void sell(String productName, int amount) {
        Product product = products.get(productName);
        if (product == null) {
            System.out.println("Product not found: " + productName);
            return;
        }

        boolean success = product.sell(amount);
        if (!success) {
            System.out.println("Not enough " + productName + " in stock");
        }
    }

    public void printStock() {
        System.out.println("\nFinal store quantities:");
        products.values().forEach(p ->
                System.out.println(p.getName() + ": " + p.getQuantity())
        );
    }
}
