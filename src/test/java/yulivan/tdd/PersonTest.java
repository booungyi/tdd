package yulivan.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {
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
}
