package dev.jcm.annotation.custom;

import dev.jcm.annotation.custom.annotation.YearRange;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomAnnotationMainTest {
    // carRequest DTO for testing purposes. Remove this inner class if carRequest is defined elsewhere.
    public static class carRequest {
        @YearRange(min = 2000, max = 2025)
        private Integer year;
        private String model;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public carRequest(String model, Integer year) {
            this.model = model;
            this.year = year;

        }

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }
    }

    @Test
    public void testValidYearRange() {
        Car car = CarFactory.createCar(new CarRequest("BMW", 2021));
        assertThat(car.getYear()).isEqualTo(2021);

        System.out.println(car);
    }

    @Test
    public void testInvalidYearRange() {
        assertThatThrownBy(() -> CarFactory.createCar(new CarRequest("BMW", 2026)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}