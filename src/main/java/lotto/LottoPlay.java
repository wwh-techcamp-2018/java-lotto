package lotto;

import java.util.List;

public class LottoPlay {

    public static final int LOTTO_PRICE = 1000;
    private LottoFactory fac;
    private List<Lotto> lottos;

    public LottoPlay(LottoFactory fac) {
        this.fac = fac;
    }

    public static int getLottoCount(int money) {
        System.out.println(money / LOTTO_PRICE + "개를 구매했습니다.");
        return money / LOTTO_PRICE;
    }

    public void buyLottos(int money) {
        lottos = fac.makeLottos(getLottoCount(money));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
