package yulivan.tdd;

import com.jayway.jsonpath.internal.function.numeric.Max;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindCarTest2 {
    @Test
    void findOldestCatsTest() {
        //given
        Cars cars = new Cars(List.of(
                new Car("1123",22,10000),
                new Car("1133",15,60000),
                new Car("1143",15,10000)
        ));

        List<Car> oldestCars = cars.oldestCars();
        assertThat(oldestCars).isEqualTo(List.of(
                new Car("1133", 15, 60000),
                new Car("1143", 15, 10000)
        ));
    }

    @Test
    void findMaxMileageCarsTest() {
        Cars cars = new Cars(List.of(
                new Car("1123",22,10000),
                new Car("1133",15,60000),
                new Car("1143",15,10000)
        ));

        //given
        List<Car> MaxMileageCars = cars.MaxMileageCars();
        assertThat(MaxMileageCars).isEqualTo(List.of(
                new Car("1133",15,60000)
        ));
    }
}
