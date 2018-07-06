package lotto.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final Integer LOTTO_MAX_VALUE = 45;

    private static Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();
    static {
        for (int i = 1; i <= LOTTO_MAX_VALUE; i++) {
            lottoNumberMap.put(i, new LottoNumber(i));
        }
    }
    private Integer lottoNumber;

    private LottoNumber(int number) {
        this.lottoNumber = number;
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    public static LottoNumber ofString(String key) {
        return lottoNumberMap.get(toInt(key));
    }

    public static LottoNumber of(Integer key) {
        if(key < 1 || key > 45)
            throw new IllegalArgumentException();
        return lottoNumberMap.get(key);
    }

    private static Integer toInt(String inputString) {
        if(inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(inputString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }


    @Override
    public int compareTo(LottoNumber o) {
        return lottoNumber.compareTo(o.getLottoNumber());
    }
}
