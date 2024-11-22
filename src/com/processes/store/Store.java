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

    public synchronized void consumes(String client) throws InterruptedException {

        while (storage.isEmpty()) {
            System.out.println(client + " has to wait, there are no vegetables available in stock");
            wait();
        }

        String vegetable = storage.remove(0);
        System.out.println(client + " consumed: " + vegetable);
        notifyAll();
    }
}
