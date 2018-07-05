package lotto.generator;

import lotto.resource.LottoNumber;

public class FixLottoGenerator implements LottoGenerator {

    @Override
    public LottoNumber[] generateNumber() {
        LottoNumber[] result = new LottoNumber[6];
        for (int i = 0; i < result.length; i++) {
            result[i] = new LottoNumber(LOTTO_NUMBER_SET[i]);
        }
        return result;
    }
}