package org.example.lession10.lession3.option2;

public class Main {
    public static void main(String[] args) {
        MachineStation station = new MachineStation();

        for (int i = 0; i < 8; i++) {
            new Thread(new Worker(i, station)).start();
        }
    }
}
