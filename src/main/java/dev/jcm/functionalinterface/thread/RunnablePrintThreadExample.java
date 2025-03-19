package dev.jcm.functionalinterface.thread;

public class RunnablePrintThreadExample {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("[" + Thread.currentThread().getName() + "] " + "Runnable Thread");

        Thread thread1 = new Thread(task);
        thread1.start();

        System.out.println("["+Thread.currentThread().getName()+"] Hello, World!");

        Thread thread2 = new Thread(task);
        thread2.start();

        Thread thread3 = new Thread(task);
        thread3.start();
    }
}
