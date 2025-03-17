package dev.jcm.annotation.custom.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//@Retention ==  Meta Annotation 중 일부, 해당 Annotation을 언제까지 유지할 것인지 설정
//@Target == Meta Annotation 중 일부, 해당 Annotation을 어디에 사용할 수 있는지 설정
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface YearRange {
    int min();
    int max();
}
