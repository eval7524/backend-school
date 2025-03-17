package dev.jcm.annotation.custom.validator;

import dev.jcm.annotation.custom.CarRequest;
import dev.jcm.annotation.custom.annotation.YearRange;

import java.lang.reflect.Field;

public class Validator {
    // 전역으로 사용 가능한 유효성 검사 메소드
    public static void validateYear(CarRequest request) {
        //@YearRange 어노테이션을 가져오려면, CarRequest에 대한 정보를 가져와야함
        try {
            Field field = request.getClass().getDeclaredField("year");
            //CarRequest에 대한 클래스 정보를 가져오고, Year라는 필드를 가져옵니다.
            field.setAccessible(true);
            //private으로 선언된 필드에 접근할 수 있도록 설정
            YearRange yr = field.getAnnotation(YearRange.class);
            //field에 있는 YearRange 어노테이션이 있다면 가져옵니다.

            int year = request.getYear();
            //request 안에 있는 year 값을 가져옵니다.

            if(year < yr.min() || year > yr.max()) {
                throw new IllegalArgumentException("year 값이 유효하지 않습니다.");
                //Validation 수행
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("year 필드가 존재하지 않습니다.");
        }
    }
}
