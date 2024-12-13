package yulivan.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindCatTest {
    @Test
    void CatTest() {
        Cat cat = new Cat();
        List<String> 이름목록 = new ArrayList<>();
        이름목록.add("치즈");
        이름목록.add("나비");
        List<Cat> 결과 = new ArrayList<>();
        for (String s : 이름목록) {
            cat.이름 = s;
            결과.add(cat);
        }
        assertThat(toCats(이름목록)).isEqualTo(결과);
    }

    @Test
    void findHeaviestolderCatsTest() {
        List<Cat> 고양이목록 = List.of(
                new Cat("나비", 3, 12),
                new Cat("치즈", 9, 12),
                new Cat("바비", 9, 3)
        );

        List<Cat> heavisetCats = findHeavisetCats(고양이목록);

        List<Cat> 무거운고양이 = List.of(
                new Cat("치즈", 9, 12),
                new Cat("바비", 9, 3)
        );
        assertThat(heavisetCats).isEqualTo(무거운고양이);

        List<Cat> oldestCats = findOldestCats(고양이목록);
        List<Cat> 나이든고양이 = List.of(
                new Cat("나비", 3, 12),
                new Cat("치즈", 9, 12)
        );

        assertThat(oldestCats).isEqualTo(나이든고양이);
    }

    List<Cat> toCats(List<String> 이름목록) {

        List<Cat> 고양이목록 = new ArrayList<>();
        Cat cat = new Cat();
        for (String 이름 : 이름목록) {
            cat.이름 = 이름;
            고양이목록.add(cat);
        }
        return 고양이목록;

    }

    List<Cat> findHeavisetCats(List<Cat> 고양이목록) {
        // List<Cat> -> List<Double>
        // 고양이 목록 -> 몸무게 목록
        // 몸무게 목록에서 최대값을 뽑아 Collections.max();
        // 새 리스트 만들고,
        // 고양이 목록에 대해 반복문, if 고양이 몸무게가 최대값과 같으면 새 리스트에 추가
        //고양이목록 = cat1,cat2
        double 기준 = 0;
        List<Double> 고양이무게 = new ArrayList<>();
        List<Cat> 가장무거운고양이들 = new ArrayList<>();
        for (Cat cat : 고양이목록) {
            고양이무게.add(cat.몸무게);

        }
        기준 = Collections.max(고양이무게);

        for (Cat cat : 고양이목록) {
            if (cat.몸무게 == 기준) {
                가장무거운고양이들.add(cat);
            }
        }

//        Cat cat = 고양이목록.get(0);
//        for (Cat cats : 고양이목록) {
//            if (cats.몸무게 >= cat.몸무게) {
//                무거운고양이.add(cats);
//            }
//        }
        return 가장무거운고양이들;
    }

    List<Cat> findOldestCats(List<Cat> 고양이목록) {
        List<Cat> 나이든고양이 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int 최대값 = 0;
        for (Cat cat : 고양이목록) {
            list.add(cat.나이);
        }
        최대값 = Collections.max(list);
        for (Cat cat : 고양이목록) {
            if (cat.나이 == 최대값) {
                나이든고양이.add(cat);
            }
        }
//        Cat cat = 고양이목록.get(0);
//        for (Cat cats : 고양이목록) {
//            if (cats.나이 >= cat.나이) {
//                나이든고양이.add(cats);
//            }
//        }
        return 나이든고양이;
    }

}
