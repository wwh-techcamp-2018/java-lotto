package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNumber {

    private static final Map<Integer, LottoNumber> lottoNums = new HashMap<Integer, LottoNumber>();

    static {
        for (int i = 1; i < 46; i++) {
            lottoNums.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    public LottoNumber(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException();
        }
        this.number = num;
    }

    public static LottoNumber of(int num) {
        return lottoNums.get(num);
    }

    public static List<LottoNumber> listOf(Integer... numbers) {
        List<LottoNumber> result = new ArrayList<>();
        for (Integer number : numbers) {
            result.add(of(number));
        }
        return result;
    }

    public static List<LottoNumber> listOf(List<Integer> numbers) {
        List<LottoNumber> result = new ArrayList<>();
        for (Integer number : numbers) {
            result.add(of(number));
        }
        return result;
    }


    private int toInt() {
        return number;
    }

    public static List<Integer> toIntList(List<LottoNumber> lottoNumbers) {
        List<Integer> result = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            result.add(lottoNumber.toInt());
        }
        return result;
    }
}
