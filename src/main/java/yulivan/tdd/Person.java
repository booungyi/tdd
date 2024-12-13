package yulivan.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    String 이름;
    String 직업;
    int 경력;

    public Person(String 이름, String 직업, int 경력) {
        this.이름 = 이름;
        this.직업 = 직업;
        this.경력 = 경력;
    }

    public Person() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(이름, person.이름);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(이름);
    }
}
