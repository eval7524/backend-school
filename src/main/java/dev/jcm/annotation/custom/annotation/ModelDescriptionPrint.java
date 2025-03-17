package dev.jcm.annotation.custom.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ModelDescriptionPrints.class)
// @Repeatable((ModelDescriptionPrints.class)) == 여러 개, 중복적인 사용 가능
public @interface ModelDescriptionPrint {
    String model();
    String description();

}
