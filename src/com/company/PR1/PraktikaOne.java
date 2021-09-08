package com.company.PR1;

public class PraktikaOne {

    private static Object object = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                ping();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                pong();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void ping() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            synchronized (object) {
                object.notify();
                System.out.println("Ping");
                object.wait();

            }
        }
    }

    public static void pong() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            synchronized (object) {
                object.notify();
                System.out.println("Pong");
                object.wait();
            }
        }
    }
}
