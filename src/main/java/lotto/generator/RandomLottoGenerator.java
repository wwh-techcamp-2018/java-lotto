package lotto.generator;

import lotto.LottoNumber;

import java.util.*;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private List<LottoNumber> lottoNumber;

    public RandomLottoGenerator() {
        lottoNumber = new ArrayList<>();
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            lottoNumber.add(new LottoNumber(i));
        }
    }

    @Override
    public Set<LottoNumber> generate() {
        Collections.shuffle(lottoNumber);
        return new TreeSet<>(lottoNumber.subList(0, 6));
    }

}
