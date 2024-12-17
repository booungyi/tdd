package yulivan.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindCatTest2 {
    @Test
    void findHeaviestCatsTest() {

        // given
        Cats cats = new Cats(List.of( // Cats 오브젝트 생성
                new Cat("나비", 4, 4),
                new Cat("비누", 5, 4),
                new Cat("헤라클라스", 5, 3)
        ));

        // when
        // List<Cat> heaviestCats = Cats.findHeaviestCats(cats);

        List<Cat> heaviestCats = cats.findHeaviestCats(); // 오브젝트가 알아서 처리

        // then
        assertThat(heaviestCats).isEqualTo(List.of(
                new Cat("비누", 5, 4),
                new Cat("헤라클라스", 5, 3)
        ));
    }

    @Test
    void findOldestCats() {
        Cats cats = new Cats(List.of(
                new Cat("나비", 4, 4),
                new Cat("비누", 5, 4),
                new Cat("헤라클라스", 5, 3)
        ));

        List<Cat> oldestCats = cats.oldestCats();
        assertThat(oldestCats).isEqualTo(List.of(
                new Cat("나비", 4, 4),
                new Cat("비누", 5, 4)
        ));

    }

}
