package org.example.lession10.lession3.option2;

import java.util.concurrent.Semaphore;

class MachineStation {
    private final Semaphore semaphore = new Semaphore(5); // 5 станков

    public void work(int id) {
        try {
            semaphore.acquire();
            System.out.println("worker " + id + " occupy production machine ...");
            Thread.sleep(2000);
            System.out.println("worker " + id + " release production machine");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}
