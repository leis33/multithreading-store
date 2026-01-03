package nbu.multithreadingProject.store;

import java.util.Map;

public class CustomerTask implements Runnable {
    private final Store store;
    private final Map<String, Integer> basket;

    public CustomerTask(Store store, Map<String, Integer> basket) {
        this.store = store;
        this.basket = basket;
    }

    @Override
    public void run() {
        for (var entry : basket.entrySet()) {
            store.sell(entry.getKey(), entry.getValue());
        }
    }
}
