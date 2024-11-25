package com.processes.thread;

import com.processes.store.Store;
import com.processes.util.Colors;

public class Farmer extends Thread {

    private String name;
    private Store store;
    private int amountOfVegetables;

    private final String[] VEGETABLES = { " lettuce", "cabbage", "onion", "spinach", "potato", "celery", "asparagus",
            "radish", "broccoli", "artichoke", "tomato", "cucumber", "eggplant", "carrot", "green bean" };

    public Farmer(String name, Store store, int amountOfVegetables) {
        this.name = name;
        this.store = store;
        this.amountOfVegetables = amountOfVegetables;
    }

    private int getGrowthTime() {
        return (int) Math.floor(Math.random() * 2) + 1;
    }

    @Override
    public void run() {

        for (int i = 0; i < this.amountOfVegetables; i++) {
            try {
                String vegetable = VEGETABLES[(int) (Math.random() * VEGETABLES.length)];
                int growthTime = getGrowthTime();

                sleep(growthTime * 1000);
                System.out.println(Colors.ANSI_YELLOW
                        + "________________________________________________________________________________" + "\n"
                        + Colors.ANSI_RESET);
                System.out.println("The vegetable: " + vegetable + ", took " + growthTime + " seconds to grow.");

                store.deposit(vegetable, this.name);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
