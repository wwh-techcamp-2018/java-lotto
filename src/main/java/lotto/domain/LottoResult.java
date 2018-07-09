package lotto.domain;

import lotto.domain.LottoNo;

public class LottoResult {
    private Lotto lotto;
    private LottoNo bonus;

    public LottoResult(Lotto lotto, LottoNo bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public boolean containsNumber(LottoNo number) {
        return lotto.contains(number);
    }


    // TODO
    public boolean containsBonusNumber(LottoNo[] lottoNumbers) {
        return false;
    }
}
