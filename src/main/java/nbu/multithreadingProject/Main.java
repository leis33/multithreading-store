package nbu.multithreadingProject;

import nbu.multithreadingProject.store.CustomerTask;
import nbu.multithreadingProject.store.Product;
import nbu.multithreadingProject.store.Store;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Map<String, Product> products = new HashMap<>();
        products.put("Apple", new Product("Apple", 100));
        products.put("Orange", new Product("Orange", 80));
        products.put("Cheese", new Product("Cheese", 50));
        products.put("Chocolate", new Product("Chocolate", 60));

        Store store = new Store(products);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 1; i <= 10; i++) {
            Map<String, Integer> basket = new HashMap<>();
            basket.put("Apple", 3);
            basket.put("Orange", 2);
            basket.put("Cheese", 1);
            basket.put("Chocolate", 1);

            executor.submit(new CustomerTask(store, basket));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        store.printStock();
    }
}