package dev.jcm.annotation.custom;

import dev.jcm.annotation.custom.annotation.ModelDescriptionPrint;
import dev.jcm.annotation.custom.annotation.ModelDescriptionPrints;

import java.time.LocalDate;

public class Car {
    private final String model;
    private final Integer year;

    public Car(String model, Integer year) {
        this.model = model;
        this.year = year;
    }

    @ModelDescriptionPrints({
            @ModelDescriptionPrint(model = "ionic", description = "new model"),
            @ModelDescriptionPrint(model = "honda", description = "steady seller"),
            @ModelDescriptionPrint(model = "grandeur", description = "luxury model"),
            @ModelDescriptionPrint(model = "Avante", description = "compact model"),
            @ModelDescriptionPrint(model = "Morning", description = "small car"),
            @ModelDescriptionPrint(model = "SM5", description = "unknown model")
    })
    public String getModel() {
        try {
            ModelDescriptionPrint[] annotations = this.getClass().getMethod("getModel").getAnnotationsByType(ModelDescriptionPrint.class);
            // 클래스에 대해서 확인 후 , 이름이 getModel인 메소드에 대해서 확인, getModel 메소드에 대한 어노테이션을 가져옴 ModelDescriptionPrint.class 의 모델들을 가져온 후
            // 복수형이니 Array로 가져옴
            for (ModelDescriptionPrint annotation : annotations) {
                if (annotation.model().equals(model)) {
                    System.out.println(annotation.description());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return model;
    }

    public Integer getYear() {
        return year;
    }

    //생산된지 5년이 넘었으면 정비가 필요합니다.
    private boolean isNeedMaintenance() {
        return LocalDate.of(year, 1, 1).isBefore(LocalDate.now().minusYears(5));
    }

    public boolean isNeedChangeOil() {
        // 오일 교체는 1개월 마다 해야함
        return LocalDate.of(year, 1, 1).isBefore(LocalDate.now().minusMonths(1));
    }
}
