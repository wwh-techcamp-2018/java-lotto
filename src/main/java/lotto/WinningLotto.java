package lotto;

public class WinningLotto {
    private Lotto winningLotto;

    public WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public int contain(LottoNumber number) {
        if (winningLotto.getNumbers().contains(number))
            return 1;
        return 0;
    }
}
