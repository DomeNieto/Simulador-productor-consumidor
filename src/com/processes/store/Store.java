package com.processes.store;

public class Store {
    private int limit;

    public Store(){
        this.limit = 20;
    }

    public int getLimit(){
        return limit;
    }

    public synchronized void deposit(){
        this.limit++;
    }

    public synchronized void collect(){
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
