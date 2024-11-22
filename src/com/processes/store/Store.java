package com.processes.store;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int limit;
    private final List<String> storage;

    public Store() {
        this.limit = 20;
        this.storage = new ArrayList<>();
    }

    public int getLimit() {
        return limit;
    }

    public synchronized void deposit(String vegetable, String nameFarmer) throws InterruptedException {
        while (this.storage.size() >= limit) {
            wait();
        }
        storage.add(vegetable);
        notifyAll();
    }

    public synchronized void collect() {
        while (this.limit <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Hilo interrumpido durante la espera.");
            }
        }
        this.limit--;
    }
}
