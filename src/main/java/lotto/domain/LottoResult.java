package lotto.domain;

import lotto.domain.LottoNo;

import java.util.Arrays;

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


    public boolean containsBonusNumber(LottoNo[] lottoNumbers) {
        return Arrays.stream(lottoNumbers).anyMatch(number -> bonus == number);
    }
}
