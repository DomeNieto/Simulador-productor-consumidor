package com.processes.thread;

import com.processes.store.Store;

public class Farmer extends Thread {

    private String name;
    private Store store;
    private final Integer AMOUNT_OF_VEGETABLES = 20;
    private final String[] VEGETABLES = { " lettuce", "cabbage", "onion", "spinach", "potato", "celery", "asparagus",
            "radish", "broccoli", "artichoke", "tomato", "cucumber", "eggplant", "carrot", "green bean" };

    public Farmer(String name, Store store) {
        this.name = name;
        this.store = store;
    }

    private int getGrowthTime() {
        return (int) Math.floor(Math.random() * (AMOUNT_OF_VEGETABLES)) + 1;
    }

    @Override
    public void run() {

        for (int i = 0; i < AMOUNT_OF_VEGETABLES; i++) {
            try {
                String vegetable = VEGETABLES[(int) (Math.random() * VEGETABLES.length)];
                int growthTime = getGrowthTime();

                sleep(growthTime * 1000);
                System.out.println("The vegetable: " + vegetable + ", took " + growthTime + "seconds to grow.");

                store.deposit(vegetable, this.name);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
