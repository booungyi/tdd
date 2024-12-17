package yulivan.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    List<Car> carList = new ArrayList<>();

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    List<Car> oldestCars() {
        List<Integer> list = new ArrayList<>();
        List<Car> car = new ArrayList<>();
        int 최소값 = 0;
        for (Car car1 : carList) {
            list.add(car1.연식);
        }
        최소값 = Collections.min(list);

        for (Car car1 : carList) {
            if (car1.연식 == 최소값) {
                car.add(car1
                );
            }
        }
        return car;
    }

    List<Car> MaxMileageCars() {
        List<Integer> list = new ArrayList<>();
        List<Car> car = new ArrayList<>();
        int 주행거리 = 0;
        for (Car car1 : carList) {
            list.add(car1.주행거리);
        }
        주행거리 = Collections.max(list);

        for (Car car1 : carList) {
            if (car1.주행거리 == 주행거리) {
                car.add(car1);
            }
        }
        return car;
    }
}
