package lotto.domain;

import lotto.domain.LottoNo;

public class LottoResult {
    private Lotto lotto;

    public LottoResult(LottoNo... resultNumbers) {
        if (resultNumbers.length != 6) {
            throw new IllegalArgumentException();
        }

        this.lotto = new Lotto(resultNumbers);
    }

    public boolean containsNumber(LottoNo number) {
        return lotto.contains(number);
    }
}
