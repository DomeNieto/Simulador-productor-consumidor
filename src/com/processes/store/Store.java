package com.processes.store;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int limit;
    private final List<String> storage;

    public Store() {
        this.limit = 10;
        this.storage = new ArrayList<>();
    }

    public int getLimit() {
        return limit;
    }

    public synchronized void deposit(String vegetable, String nameFarmer) throws InterruptedException {
        while (this.storage.size() >= limit) {
            System.err.println("Storage is full, please wait: " + nameFarmer);
            wait();
        }
        storage.add(vegetable);
        notifyAll();

        System.out.println("The farmer " + nameFarmer + " has added a " + vegetable + " in the store.");
        System.out.println("The storage status: " + storage.size() + "\n");
    }

    public synchronized void consumes(String client) throws InterruptedException {

        while (storage.isEmpty()) {
            System.out.println(client + " has to wait, there are no vegetables available in stock.\n");
            wait();
        }

        String vegetable = storage.remove(0);
        System.out.println(client + " consumed: " + vegetable + "\n");
        notifyAll();
    }
}