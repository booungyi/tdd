package yulivan.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindDeveloperTest {
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
}
