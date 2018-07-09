package lotto.values;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        if (lotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        this.lotto = lotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }


    public Rank match(Lotto targetLotto) {
        return Rank.valueOf(targetLotto.match(this.lotto), targetLotto.hasNumber(bonusNumber.toInt()));
    }
}
