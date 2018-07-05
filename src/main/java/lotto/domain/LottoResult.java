package lotto.domain;

import lotto.domain.LottoNo;

public class LottoResult {
    private LottoNo[] resultNumbers;

    public LottoResult(LottoNo... resultNumbers) {
        if (resultNumbers.length != 6) {
            throw new IllegalArgumentException();
        }
        this.resultNumbers = resultNumbers;
    }

    public boolean containsNumber(LottoNo number) {
        for (LottoNo resultNumber : resultNumbers) {
            if (resultNumber.equals(number)) {
                return true;
            }
        }
        return false;
    }
}
