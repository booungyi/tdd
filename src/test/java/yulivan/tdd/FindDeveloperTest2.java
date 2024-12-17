package yulivan.tdd;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindDeveloperTest2 {

    @Test
    void findSeniorDeveloperTest() {

        Person2 person2 = new Person2(List.of(
                new Person("김", "파이썬", 12),
                new Person("나", "자바", 15),
                new Person("박", "c#", 15),
                new Person("이", "백엔드", 10)
        ));

        List<Person> findSeniorDeveloper = person2.findSeniorDevelopper();

        assertThat(findSeniorDeveloper).isEqualTo(List.of(
                new Person("나", "자바", 15),
                new Person("박", "c#", 15)
        ));
    }
}
