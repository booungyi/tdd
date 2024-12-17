package yulivan.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person2 {
    List<Person> personList = new ArrayList<>();

    public Person2(List<Person> personList) {
        this.personList = personList;
    }

     public List<Person> findSeniorDevelopper() {
        List<Integer> list = new ArrayList<>();
        List<Person> 경력직 = new ArrayList<>();
        int 최대경력 = 0;

        for (Person person : personList) {
            list.add(person.경력);
        }
        최대경력 = Collections.max(list);
        for (Person person : personList) {
            if (person.경력==최대경력) {
                경력직.add(person);
            }
        }
        return 경력직;
    }
}
