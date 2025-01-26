package ru.otus.homework.hw21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample {
    private  String nextChar = "A";

    public ThreadExample() {
        ExecutorService serv = Executors.newFixedThreadPool(4);

        serv.execute(() -> {
            for(int i = 0; i < 5; i++) {
                printChar("A");
                try {
                    Thread.sleep(1000 + (int)(1000 * Math.random()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        serv.execute(() -> {
            for(int i = 0; i < 5; i++) {
                printChar("B");
                try {
                    Thread.sleep(1000 + (int)(1000 * Math.random()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        serv.execute(() -> {
            for(int i = 0; i < 5; i++) {
                printChar("C");
                try {
                    Thread.sleep(1000 + (int)(1000 * Math.random()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        serv.shutdown();
    }

    public synchronized void  printChar(String ch) {
        while (!this.nextChar.equals(ch)) {
            try {
                //System.out.println("ждём  " + ch + " last char " + lastChar);
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(ch);

        if (ch.equals("A")) this.nextChar = "B";
        else if (ch.equals("B")) this.nextChar = "C";
        else if (ch.equals("C")) this.nextChar = "A";

        notifyAll();
    }
}
