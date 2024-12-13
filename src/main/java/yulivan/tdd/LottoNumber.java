package yulivan.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    int 번호;

    public LottoNumber() {
    }
// 0 1 2 3 4 5
// 1
// 2 2
    public LottoNumber(int 번호) {
        this.번호 = 번호;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return 번호 == that.번호;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(번호);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "번호=" + 번호 +
                '}';
    }
}
