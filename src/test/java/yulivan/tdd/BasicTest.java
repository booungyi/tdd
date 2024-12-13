package yulivan.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.ast.Literal;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicTest {
    @Test
    void ToIntegersTest() {
        List<String> 주어지는것 = new ArrayList<>(List.of("1", "12", "1223", "12222"));
        List<Integer> 결과 = new ArrayList<>(List.of(1, 12, 1223, 12222));
        assertThat(toIntegers(주어지는것)).isEqualTo(결과);


    }

    private List<Integer> toIntegers(List<String> 주어지는것) {
        List<Integer> 결과 = new ArrayList<>();
        for (String s : 주어지는것) {
            결과.add(Integer.parseInt(s));
        }
        return 결과;
    }

    @Test
    void ToPersonsTest() {
        Person person = new Person();
        List<String> 사람목록 = new ArrayList<>();
        사람목록.add("황정민");
        사람목록.add("마동석");

        List<Person> 결과 = new ArrayList<>();
        for (String 사람 : 사람목록) {
            person.이름 = 사람;
            결과.add(person);
        }
        assertThat(toPersons(사람목록)).isEqualTo(결과);
//        List<Person> 환자들 = new ArrayList<>();

//        Person person = new Person();
//        person.이름 = "김OO";
//        person.병명 = "감기";
//        환자들.add(person);
        // ..
//        Person 찾은환자 = 환자들.find("김OO");
//        System.out.println(찾은환자.병명);
//        for (String s : 사람목록) {
//            person.이름 = s;
//            결과.add(person);
//        }
    }

    private List<Person> toPersons(List<String> 이름목록) {
        List<Person> 사람목록 = new ArrayList<>();
        Person person = new Person();
        for (String 이름 : 이름목록) {
            person.이름 = 이름;
            사람목록.add(person);
        }
        return 사람목록;
    }


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

    List<Cat> toCats(List<String> 이름목록) {

        List<Cat> 고양이목록 = new ArrayList<>();
        Cat cat = new Cat();
        for (String 이름 : 이름목록) {
            cat.이름 = 이름;
            고양이목록.add(cat);
        }
        return 고양이목록;

    }

    @Test
    void findMAxValuesTest() {
        List<Integer> 정수리스트 = new ArrayList<>();
        정수리스트.add(1);
        정수리스트.add(2);
        정수리스트.add(3);

        assertThat(findMaxValues(정수리스트)).isEqualTo(3);

    }

    int findMaxValues(List<Integer> 정수리스트) {
        int 가장큰수 = 0;
        for (Integer i : 정수리스트) {
            가장큰수 = 가장큰수 > i ? 가장큰수 : i;
        }
        return 가장큰수;
    }

    @Test
    void findHeaviestolderCatsTest() {
//        Cat cat1 = new Cat("나비",122,12);
//        Cat cat2 = new Cat("치즈",1222,212);
//        List<Cat> 고양이목록 = new ArrayList<>();
//        고양이목록.add(cat1);
//        고양이목록.add(cat2);
        List<Cat> 고양이목록 = List.of(
                new Cat("나비", 3, 12),
                new Cat("치즈", 9, 12),
                new Cat("바비", 9, 3)
        );

        List<Cat> heavisetCats = findHeavisetCats(고양이목록);

//        List<Cat> 무거운고양이 = new ArrayList<>();
//        무거운고양이.add(cat2);
        List<Cat> 무거운고양이 = List.of(
                new Cat("치즈", 9, 12),
                new Cat("바비", 9, 3)
        );

        assertThat(heavisetCats).isEqualTo(무거운고양이);

        List<Cat> oldestCats = findOldestCats(고양이목록);

//        List<Cat> 나이든고양이 = new ArrayList<>();
//        나이든고양이.add(cat2);
        List<Cat> 나이든고양이 = List.of(
                new Cat("나비", 3, 12),
                new Cat("치즈", 9, 12)
        );

        assertThat(oldestCats).isEqualTo(나이든고양이);
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
//        1. 주어진 String 리스트의 String 을 하나씩읽으세요
//        2. 읽은 String을 int로 바꾼 값을 구하세요
//        Integer.parseInt()
//        3. int 로 바꾼값을 새 리스트에 추가하세요
//        4.다 추가했으면 return 하세요
//String -> int



