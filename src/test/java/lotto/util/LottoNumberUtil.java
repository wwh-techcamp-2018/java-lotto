package lotto.util;

import lotto.domain.LottoNo;

public class LottoNumberUtil {

    public static LottoNo[] lottoNumbers(int... numbers) {
        LottoNo[] lottoNumbers = new LottoNo[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            lottoNumbers[i] = LottoNo.of(numbers[i]);
        }

        return lottoNumbers;
    }
}
