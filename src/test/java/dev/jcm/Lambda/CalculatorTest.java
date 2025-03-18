package dev.jcm.Lambda;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator(10, 20);
        int result = calculator.calculate(
                new Operate() {
                    //Operate 라는 익명 클래스를 만듭니다.
                    public int operate(int a, int b) {
                        return a + b;
                    }
                }
        );

        System.out.println(result);
    }


    @Test
    void testAddLambda() {
        Calculator calculator = new Calculator(10, 20);
        int result = calculator.calculate((a, b) -> a + b);
        System.out.println(result);
    }

    @Test
    void testAddLambda2() {
        Calculator calculator = new Calculator(10, 20);
        Operate operate = (a,b) -> a + b;
        int result = calculator.calculate(operate);

        System.out.println(result);
    }

    @Test
    void testAddLambda3() {
        Calculator calculator = new Calculator(10, 20);
        int result = calculator.calculate(getOperate());

        System.out.println(result);

    }

    private Operate getOperate() {
        return Integer::sum;
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator(20, 10);
        int result = calculator.calculate((a, b) -> a - b);
        System.out.println(result);
    }

}