package lottery;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void draw() {
        this.lotto.draw();
    }

    public List<LottoNumber> getLotto() {
        return this.lotto.getLotto();
    }

    public int contains(LottoNumber lottoNumber) {
        if (lotto.contains(lottoNumber))
            return 1;
        return 0;
    }
}
