package nbu.multithreadingProject.store;

public class Product {
    private final String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public synchronized boolean sell(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
