package com.processes.thread;

import com.processes.store.Store;
import com.processes.util.Colors;

public class Client extends Thread {

    private Store store;
    private String name;
    private int amount;

    public Client(Store store, String name, int amount) {

        this.store = store;
        this.name = name;
        this.amount = amount;

    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < amount; i++) {
                Thread.sleep((int) (Math.random() * 1000));
                store.consumes(name);
                System.out.println(Colors.ANSI_GREEN + "\t!! " + "The client " + this.name + " has consumed: " + (i + 1)  + Colors.ANSI_RESET);
            }

            System.out.println(Colors.ANSI_GREEN + "\t-> " + "The client " + this.name + " has consumed all their veggies." + Colors.ANSI_RESET);
        } catch (InterruptedException e) {
            System.out.println(Colors.ANSI_RED + "Error Interrupted Exception" + Colors.ANSI_RESET);
        }
    }
}
