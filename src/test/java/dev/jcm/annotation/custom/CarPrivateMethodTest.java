package dev.jcm.annotation.custom;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPrivateMethodTest {
    @Test
    public void NeedMaintenance() throws Exception {
        // 현재 기준 6년 전의 연도를 사용하여 5년 이상 경과한 차량 생성
        int productionYear = LocalDate.now().minusYears(6).getYear();
        Car carMaintenance = new Car("testModel", productionYear);

        // private 메소드인 isNeedMaintenance()에 접근
        Method method = Car.class.getDeclaredMethod("isNeedMaintenance");
        method.setAccessible(true);
        boolean maintenanceNeeded = (boolean) method.invoke(carMaintenance);

        // 5년 이상 경과하였으므로 정비가 필요해야 함
        assertThat(maintenanceNeeded).isTrue();
    }

    @Test
    public void NotNeedMaintenance() throws Exception {
        int productionYear = LocalDate.now().minusYears(4).getYear();
        Car carMaintenance = new Car("testModel", productionYear);

        Method method = Car.class.getDeclaredMethod("isNeedMaintenance");
        method.setAccessible(true);
        boolean maintenanceNeeded = (boolean) method.invoke(carMaintenance);
        //invoke == 호출

        assertThat(maintenanceNeeded).isFalse();
    }

    @Test
    public void needChangeOil() {
        int productionYear = LocalDate.now().getYear();
        Car carChangeOil = new Car("testModel", productionYear);

        boolean changeOil = carChangeOil.isNeedChangeOil();
        assertThat(changeOil).isTrue();
    }

    public void NotNeedChangeOil() {
        int productionYear = LocalDate.now().minusMonths(1).getYear();
        Car carChangeOil = new Car("testModel", productionYear);

        boolean changeOil = carChangeOil.isNeedChangeOil();
        assertThat(changeOil).isFalse();
    }
}