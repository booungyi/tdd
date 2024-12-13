package yulivan.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindCarTest {
    @Test
    void findOldestCarsTest() {
        List<Car> 중고차들 = List.of(new Car("12가3456", 2018, 20000)
                , new Car("14허3323", 2010, 16660)
                , new Car("15바3673", 2000, 200000)
                , new Car("16가8883", 2020, 10));


        List<Car> 가장오래된차 = new ArrayList<>(
                List.of(new Car("15바3673", 2000, 200000))
        );

        List<Car> 가장주행거리가긴차 = new ArrayList<>(
                List.of(new Car("15바3673", 2000, 200000))
        );

        assertThat(findOldestCar(중고차들)).isEqualTo(가장오래된차);
        assertThat(findMaxMileagecars(중고차들)).isEqualTo(가장주행거리가긴차);
    }

    private List<Car> findOldestCar(List<Car> 중고차들) {
        List<Integer> 연식 = new ArrayList<>();
        int 늙은차 = 0;
        List<Car> 가장연식이오래된차 = new ArrayList<>();
        for (Car car : 중고차들) {
            연식.add(car.연식);
        }
        늙은차 = Collections.min(연식);

        for (Car car : 중고차들) {
            if (car.연식 == 늙은차) {
                가장연식이오래된차.add(car);
            }
        }
        return 가장연식이오래된차;
    }

    private List<Car> findMaxMileagecars(List<Car> 중고차들) {
        int 주행 = 0;

        List<Integer> 주행거리 = new ArrayList<>();
        List<Car> 가장주행거리가긴차 = new ArrayList<>();
        for (Car car : 중고차들) {
            주행거리.add(car.주행거리);
        }
        주행 = Collections.max(주행거리);
        for (Car car : 중고차들) {
            if (car.주행거리 == 주행) {
                가장주행거리가긴차.add(car);
            }
        }
        return 가장주행거리가긴차;
    }




}
