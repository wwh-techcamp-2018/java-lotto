package lotto.generator;

import lotto.resource.LottoNumber;

public interface LottoGenerator {
    public static final Integer[] LOTTO_NUMBER_SET = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public LottoNumber[] generateNumber();
}

