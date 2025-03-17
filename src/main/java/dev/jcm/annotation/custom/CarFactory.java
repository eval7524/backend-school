package dev.jcm.annotation.custom;

import dev.jcm.annotation.custom.validator.Validator;

public class CarFactory {
    public static Car createCar(CarRequest carRequest) {
        Validator.validateYear(carRequest);
        return new Car(carRequest.getModel(), carRequest.getYear());
    }
}
