package yulivan.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckLottoRank {
    @Test
    void checkLottoRankTest() {

        LottoRank lottoRank = new LottoRank(List.of(
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

        List<LottoNumber> checkLottoRank = LottoRank.checkLottoRank();

        assertThat(checkLottoRank(당첨번호목록, lottoRank.checkLottoRank(),보너스번호)).isEqualTo(2);

    }
}
