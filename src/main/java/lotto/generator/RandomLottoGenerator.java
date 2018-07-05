package lotto.generator;

import lotto.resource.LottoNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public LottoNumber[] generateNumber() {
        return getSixNumbers(shuffleNumbers());
    }

    private LottoNumber[] getSixNumbers(List<Integer> lottoNumberSet) {
        LottoNumber[] numbers = new LottoNumber[6];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new LottoNumber(lottoNumberSet.get(i));
        }
        return numbers;
    }

    private List<Integer> shuffleNumbers() {
        List<Integer> lottoNumberSet = Arrays.asList(LOTTO_NUMBER_SET);
        Collections.shuffle(lottoNumberSet);
        return lottoNumberSet;
    }
}