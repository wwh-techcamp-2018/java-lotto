package lotto;

import lotto.resource.LottoNumber;

public class WinningLotto {
    private static Lotto lotto;
    private static LottoNumber bonus;

    public WinningLotto(Lotto lotto, LottoNumber bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public int match(Lotto lotto) {
        int count = lotto.match(this.lotto);
        return count;
    }

    public boolean isMatchBonus(Lotto lotto) {
        return lotto.contains(bonus);
    }
}
