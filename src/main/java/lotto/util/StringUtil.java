package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.LottoResult;

public class StringUtil {
    public static LottoResult parseToLottoResult(String s, int bonusNumber) {
        return new LottoResult(parseToLotto(s), LottoNo.of(bonusNumber));
    }

    public static Lotto parseToLotto(String s) {
        return new Lotto(toLottoNumbers(split(s)));
    }

    private static String[] split(String text) {
        return text.split(",");
    }

    private static LottoNo[] toLottoNumbers(String[] values) {
        LottoNo[] lottoNumbers = new LottoNo[values.length];
        for (int i = 0; i < values.length; i++) {
            lottoNumbers[i] = LottoNo.of(values[i]);
        }
        return lottoNumbers;
    }
}
