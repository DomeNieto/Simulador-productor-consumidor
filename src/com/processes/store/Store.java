package com.processes.store;

import java.util.ArrayList;
import java.util.List;

import com.processes.util.Colors;

public class Store {
    private int limit;
    private final List<String> storage;

    public Store(int limit) {
        this.limit = limit;
        this.storage = new ArrayList<>();
    }

    public int getLimit() {
        return limit;
    }

    public synchronized void deposit(String vegetable, String nameFarmer) throws InterruptedException {
        while (this.storage.size() >= limit) {
            System.err.println(Colors.ANSI_RED + "Storage is full, please wait: " + nameFarmer + Colors.ANSI_RESET);
            wait();
        }
        storage.add(vegetable);
        notifyAll();

        System.out.println(Colors.ANSI_GREEN + "The farmer " + nameFarmer + " has added a(n) " + vegetable
                + " into the store." + Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_CYAN + "The storage status: " + storage.size() + Colors.ANSI_RESET);
        System.out.println(
                Colors.ANSI_YELLOW + "________________________________________________________________________________"
                        + "\n" + Colors.ANSI_RESET);
    }

    public synchronized void consumes(String client) throws InterruptedException {

        while (storage.isEmpty()) {
            System.out.println(Colors.ANSI_RED + "\t-> " + client
                    + " has to wait, there are no vegetables available in stock." + Colors.ANSI_RESET);
            wait();
        }

        String vegetable = storage.remove(0);
        System.out.println(Colors.ANSI_CYAN + "\t-> " + client + " consumed: " + vegetable + Colors.ANSI_RESET);
        notifyAll();
    }
}