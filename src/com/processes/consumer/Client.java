package com.processes.consumer;

import com.processes.store.Store;

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
            }
        } catch (InterruptedException e) {
            System.out.println("Error Interrupted Exception");
        }
    }
}
