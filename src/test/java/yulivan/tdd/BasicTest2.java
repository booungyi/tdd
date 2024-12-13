package yulivan.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicTest2 {
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

    @Test
    void findSeniorDevelopperTest() {
        List<Person> 사람들 = new ArrayList<>(
                List.of(
                        new Person("김씨", "개발자", 5),
                        new Person("박씨", "백수", 10),
                        new Person("조씨", "셀러리맨", 15),
                        new Person("이씨", "엔지니어", 30)
                )
        );
        List<Person> 알파경력직 = new ArrayList<>(
                List.of(
                        new Person("이씨", "엔지니어", 30)
                ));
        List<Person> 개발자중최강 = new ArrayList<>(
                List.of(
                        new Person("김씨", "개발자", 5)
                ));
        assertThat(findSenior(사람들)).isEqualTo(알파경력직);
        assertThat(findSeniorDevelopper(사람들)).isEqualTo(개발자중최강);
    }

    private List<Person> findSenior(List<Person> 사람들) {
        List<Integer> 경력 = new ArrayList<>();
        List<Person> 알파경력직 = new ArrayList<>();
        int 경력최대값 = 0;
        for (Person person : 사람들) {
            경력.add(person.경력);
        }
        경력최대값 = Collections.max(경력);
        for (Person person : 사람들) {
            if (person.경력 == 경력최대값) {
                알파경력직.add(person);

            }
        }
        return 알파경력직;
    }

    List<Person> findSeniorDevelopper(List<Person> 사람들) {
        List<Integer> 경력 = new ArrayList<>();
        List<Person> 알파경력직 = new ArrayList<>();
        int 개발자중최강 = 0;

        for (Person person : 사람들) {
            if (person.직업.equals("개발자")) {
                경력.add(person.경력);
            }
        }
        개발자중최강 = Collections.max(경력);
        for (Person person : 사람들) {
            if (person.직업.equals("개발자") && person.경력 == 개발자중최강) {
                알파경력직.add(person);
            }
        }
        return 알파경력직;
    }

    @Test
    void checkLottoTest() {
        LottoNumber lottoNumber = new LottoNumber();
        List<Integer> 번호목록 = new ArrayList<>(
                List.of(1, 2, 3, 4, 5, 6)
        );


        List<LottoNumber> 로또번호목록 = new ArrayList<>(
                List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                ));
        assertThat(toLottoNumbers(번호목록)).isEqualTo(로또번호목록);
    }

    List<LottoNumber> toLottoNumbers(List<Integer> 번호목록) {

        List<LottoNumber> 로또번호 = new ArrayList<>();
        for (Integer i : 번호목록) {
            LottoNumber lottoNumber = new LottoNumber();
            lottoNumber.번호 = i;
            로또번호.add(lottoNumber);
        }
        return 로또번호;
    }

    @Test
    void checkLottoRankTest() {

        List<LottoNumber> 로또번호목록 = new ArrayList<>(
                List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                ));
        List<Integer> 당첨번호목록 = new ArrayList<>(
                List.of(7, 2, 3, 4, 5, 6)
        );
        int 보너스번호 = 1;

        assertThat(checkLottoRank(로또번호목록, 당첨번호목록,보너스번호)).isEqualTo(2);

    }

    int checkLottoRank(List<LottoNumber> 로또번호, List<Integer> 당첨번호,int 보너스번호) {
        //TOdo 방법1 : 당첨번호를 로또번호 변수로받는다.
//        List<LottoNumber> 당첨번호변경 = new ArrayList<>();
//        for (Integer i : 당첨번호) {
//            lottoNumber.번호 = i;
//            당첨번호변경.add(lottoNumber);
//        }
        //TOdo 방법2: 로또번호를 정수로 받는다.
        List<Integer> 로또번호변경 = new ArrayList<>();
        for (LottoNumber number : 로또번호) {
            LottoNumber lottoNumber = new LottoNumber();
            로또번호변경.add(number.번호);
        }
        int 등수 = 0;
        for (Integer 번호 : 당첨번호) {
            for (Integer 로또 : 로또번호변경) {
                if (번호.equals(로또)) {
                    등수++;
                }
            }
        }
        if (등수 == 3) {
            return 5;
        } else if (등수 == 4) {
            return 4;
        } else if (등수 == 5) {
            for (Integer  lottoNumber: 로또번호변경) {
                if (lottoNumber == 보너스번호) {
                    return 2;
                }
            }
            return 3;
        } else if (등수 == 6) {
            return 1;
        }
        return 6;
    }

    int checkLottoRank2(List<LottoNumber> 로또번호, List<Integer> 당첨번호) {
        List<Integer> 로또번호변환 = new ArrayList<>();


        return 0;
    }


}
