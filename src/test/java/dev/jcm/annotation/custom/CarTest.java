package dev.jcm.annotation.custom;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void testGetModelIonic() {
        Car car = new Car("ionic", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelHonda() {
        Car car = new Car("honda", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelGrandeur() {
        Car car = new Car("grandeur", 2021);
        car.getModel();

    }

    @Test
    public void testGetModelAvante() {
        Car car = new Car("Avante", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelMorning() {
        Car car = new Car("Morning", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelUnknown() {
        Car car = new Car("SM5", 2021);
        car.getModel();
    }
}