package org.example.lession10.lession3.option1;

public class FactoryWorker implements Runnable {
    private final int id;

    public FactoryWorker(int id) {
        this.id = id;
    }

    private void workOnMachine() {
        try {
            System.out.println("worker " + id + " occupy production machine ...");
            Thread.sleep(2000);
            System.out.println("worker " + id + " release production machine");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        workOnMachine();
    }
}
