package yulivan.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cats {

    List<Cat> cats = new ArrayList<>();

    public Cats(List<Cat> cats) {
        this.cats = cats;
    }

    List<Cat> findHeaviestCats() {
        List<Cat> 무거운고양이 = new ArrayList<>();
        List<Double> list = new ArrayList<>();
        double 최대값 = 0;
        for (Cat cat1 : cats) {
            list.add(cat1.몸무게);
        }
        최대값 = Collections.max(list);
        for (Cat cat1 : cats) {
            if (cat1.몸무게 == 최대값) {
                무거운고양이.add(cat1);
            }
        }
        return 무거운고양이;
    }
    List<Cat> oldestCats( ) {
        List<Cat> cat = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int 최대값 = 0;
        for (Cat cat1 : cats) {
            list.add(cat1.나이);
        }
        최대값 = Collections.max(list);
        for (Cat cat1 : cats) {
            if (cat1.나이 == 최대값) {
                cat.add(cat1);
            }
        }
        return cat;
    }

}

