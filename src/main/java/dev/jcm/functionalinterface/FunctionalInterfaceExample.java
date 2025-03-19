package dev.jcm.functionalinterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Consumer: 입력값을 받아 처리만 하고 반환값은 없음
        Consumer<String> printConsumer = s -> System.out.println("Consumer: " + s);
        printConsumer.accept("Hello, Consumer!");

        // Supplier: 입력값 없이 결과값을 공급함
        Supplier<String> stringSupplier = () -> "Hello from Supplier!";
        // Return 이라고 명시가 되지 않은 이유는, 한줄밖에 없기 때문에 return 이라는 키워드를 생략해도 된다. 자동적으로 return 된다.
        System.out.println("Supplier: " + stringSupplier.get());

        // Predicate: 입력값을 받아 boolean 을 반환함
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 5 even? " + isEven.test(5));

        // Function: 입력값을 받아 결과값을 반환함
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("문자열 길이 : "+stringLength.apply("안녕하세요"));

    }
}