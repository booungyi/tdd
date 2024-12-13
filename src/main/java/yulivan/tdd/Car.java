package yulivan.tdd;

import java.util.Objects;

public class Car
{
    String 차량번호;
    int 연식;
    int 주행거리;

    public Car(String 차량번호, int 연식, int 주행거리) {

        this.차량번호 = 차량번호;
        this.연식 = 연식;
        this.주행거리 = 주행거리;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return 연식 == car.연식 && 주행거리 == car.주행거리 && Objects.equals(차량번호, car.차량번호);
    }

    @Override
    public int hashCode() {
        return Objects.hash(차량번호, 연식, 주행거리);
    }
}
