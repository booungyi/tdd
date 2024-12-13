package yulivan.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.ast.Literal;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerTest {
    @Test
    void ToIntegersTest() {
        List<String> 주어지는것 = new ArrayList<>(List.of("1", "12", "1223", "12222"));
        List<Integer> 결과 = new ArrayList<>(List.of(1, 12, 1223, 12222));
        assertThat(toIntegers(주어지는것)).isEqualTo(결과);
    }
    @Test
    void findMAxValuesTest() {
        List<Integer> 정수리스트 = new ArrayList<>();
        정수리스트.add(1);
        정수리스트.add(2);
        정수리스트.add(3);

        assertThat(findMaxValues(정수리스트)).isEqualTo(3);
    }
    private List<Integer> toIntegers(List<String> 주어지는것) {
        List<Integer> 결과 = new ArrayList<>();
        for (String s : 주어지는것) {
            결과.add(Integer.parseInt(s));
        }
        return 결과;
    }
    int findMaxValues(List<Integer> 정수리스트) {
        int 가장큰수 = 0;
        for (Integer i : 정수리스트) {
            가장큰수 = 가장큰수 > i ? 가장큰수 : i;
        }
        return 가장큰수;
    }
}
//        1. 주어진 String 리스트의 String 을 하나씩읽으세요
//        2. 읽은 String을 int로 바꾼 값을 구하세요
//        Integer.parseInt()
//        3. int 로 바꾼값을 새 리스트에 추가하세요
//        4.다 추가했으면 return 하세요
//String -> int



