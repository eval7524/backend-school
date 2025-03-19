package dev.jcm.functionalinterface.thread;

public class RunnableExample {
    public static void main(String[] args) {
        // Runnable 인터페이스는 FunctionalInterface이다.
        // Runnable 인터페이스는 run() 메소드를 가지고 있다.
        // run 메소드는 매개변수도 없고, 리턴값도 없다.
        // 주로 사용되는 케이스 : 스레드에 넣을 task를 만들고, 이를 실행할 때 사용한다.
        // 메인 스레드는 신경쓰지 않는다.
        Runnable task = () -> System.out.println("Hello, World!");

        Thread thread = new Thread(task);
        thread.start();
    }
}
