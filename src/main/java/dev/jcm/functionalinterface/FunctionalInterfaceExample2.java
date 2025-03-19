package dev.jcm.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

public class FunctionalInterfaceExample2 {
    public static void main(String[] args) {
        // BiConsumer: 입력값을 두 개 받아 처리만 하고 반환값은 없음
        BiConsumer<String, Integer> biConsumer = (str, num) ->
                System.out.println("BiConsumer 결과: 문자열 \"" + str + "\" 의 길이는 " + num + " 입니다.");
        biConsumer.accept("안녕하세요", 5);

        // BiFunction: 입력값을 두 개 받아 결과값을 반환함
        BiFunction<Integer, Integer, String> biFunction = (a, b) ->
                "BiFunction 결과: 두 수 " + a + " + " + b + " = " + (a + b);
        System.out.println(biFunction.apply(3, 7));

        // BinaryOperator: 입력값을 두 개 받아 같은 타입의 결과값을 반환함
        BinaryOperator<Integer> binaryOperator = (a, b) -> a / b;
        System.out.println("BinaryOperator 결과: 두 수의 나눗셈 = " + binaryOperator.apply(6, 3));

        // BiPredicate: 입력값을 두 개 받아 boolean 을 반환함
        BiPredicate<String, String> biPredicate = (a, b) -> a.equals(b);
        System.out.println("BiPredicate 결과: 두 문자열이 같은가? " + biPredicate.test("테스트", "테스트"));
    }
}