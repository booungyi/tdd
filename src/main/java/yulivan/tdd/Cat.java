package yulivan.tdd;

import java.util.Objects;

public class Cat {
    String 이름="";
    double 몸무게=0.0;
    int 나이=0;

    public Cat(String 이름, double 몸무게, int 나이) {
        this.이름 = 이름;
        this.몸무게 = 몸무게;
        this.나이 = 나이;
    }

    public Cat() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Double.compare(몸무게, cat.몸무게) == 0 && 나이 == cat.나이 && Objects.equals(이름, cat.이름);
    }

    @Override
    public int hashCode() {
        return Objects.hash(이름, 몸무게, 나이);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "이름='" + 이름 + '\'' +
                ", 몸무게=" + 몸무게 +
                ", 나이=" + 나이 +
                '}';
    }
}
