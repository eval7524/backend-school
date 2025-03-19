package dev.jcm.functionalinterface.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallablePrintThreadExample {
    public static void main(String[] args) {
        // Callable 인터페이스는 매개변수는 없지만, 반환형은 있는 성실한 인터페이스
        // 주로 사용되는 케이스 : task를 만드는 것 까진 동일하지만, 반환형을 받아서 다른 일을 하고싶을 때 사용
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // Callable 에서 task는 실행을 하면, String 문자열을 반환한다는 뜻이다.
        Callable<String> task = () -> {
            String result = "Result 123";
            System.out.println("[" + Thread.currentThread().getName() + "] " + result);
            return result;
        };
        // 메인 스레드와 Callable 스레드는 나중에 가져와야함
        // 따라서 Future라는 개념을 사용한다.
        Future<String> future = executor.submit(task);

        try {
            System.out.println("["+Thread.currentThread().getName()+"] Callable Result : " + future.get());
            // try-catch에서, Callable Result 를 문자열로 만들고, 이 뒤에서 future에 있는걸 받아옵니다.
            // result 123 은 task 에서 가지고 있고, task는 Callable 로 구현
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
