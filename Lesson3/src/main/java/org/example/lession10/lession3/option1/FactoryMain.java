package org.example.lession10.lession3.option1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FactoryMain {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5); // 5 станков

        for (int i = 0; i < 8; i++) {
            pool.submit(new FactoryWorker(i));
        }

        pool.shutdown();
    }
}

