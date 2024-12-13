package yulivan.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindLottoNumTest {
    @Test
    void checkLottoTest() {
        LottoNumber lottoNumber = new LottoNumber();
        List<Integer> 번호목록 = new ArrayList<>(
                List.of(1, 2, 3, 4, 5, 6)
        );


        List<LottoNumber> 로또번호목록 = new ArrayList<>(
                List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                ));
        assertThat(toLottoNumbers(번호목록)).isEqualTo(로또번호목록);
    }

    List<LottoNumber> toLottoNumbers(List<Integer> 번호목록) {

        List<LottoNumber> 로또번호 = new ArrayList<>();
        for (Integer i : 번호목록) {
            LottoNumber lottoNumber = new LottoNumber();
            lottoNumber.번호 = i;
            로또번호.add(lottoNumber);
        }
        return 로또번호;
    }

    @Test
    void checkLottoRankTest() {

        List<LottoNumber> 로또번호목록 = new ArrayList<>(
                List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                ));
        List<Integer> 당첨번호목록 = new ArrayList<>(
                List.of(7, 2, 3, 4, 5, 6)
        );
        int 보너스번호 = 1;

        assertThat(checkLottoRank(로또번호목록, 당첨번호목록, 보너스번호)).isEqualTo(2);

    }

    int checkLottoRank(List<LottoNumber> 로또번호, List<Integer> 당첨번호, int 보너스번호) {
        //TOdo 방법1 : 당첨번호를 로또번호 변수로받는다.
//        List<LottoNumber> 당첨번호변경 = new ArrayList<>();
//        for (Integer i : 당첨번호) {
//            lottoNumber.번호 = i;
//            당첨번호변경.add(lottoNumber);
//        }
        //TOdo 방법2: 로또번호를 정수로 받는다.
        List<Integer> 로또번호변경 = new ArrayList<>();
        for (LottoNumber number : 로또번호) {
            LottoNumber lottoNumber = new LottoNumber();
            로또번호변경.add(number.번호);
        }
        int 등수 = 0;
        for (Integer 번호 : 당첨번호) {
            for (Integer 로또 : 로또번호변경) {
                if (번호.equals(로또)) {
                    등수++;
                }
            }
        }
        if (등수 == 3) {
            return 5;
        } else if (등수 == 4) {
            return 4;
        } else if (등수 == 5) {
            for (Integer lottoNumber : 로또번호변경) {
                if (lottoNumber == 보너스번호) {
                    return 2;
                }
            }
            return 3;
        } else if (등수 == 6) {
            return 1;
        }
        return 6;
    }

    int checkLottoRank2(List<LottoNumber> 로또번호, List<Integer> 당첨번호) {
        List<Integer> 로또번호변환 = new ArrayList<>();
        return 5;
    }
}
