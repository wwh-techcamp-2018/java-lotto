package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private static final int DEFAULT_PRICE = 1000;

    public static List<Lotto> createLottoList(int money) {
        return createLottos(getLottoCount(money));
    }

    public static int getLottoCount(int money) {
        return money / DEFAULT_PRICE;
    }

    private static List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(createAutoLotto());
        }
        return lottos;
    }

    private static Lotto createAutoLotto() {
        return Lotto.ofBlank();
    }
}
