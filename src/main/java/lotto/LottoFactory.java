package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public static List<Lotto> createLotto(int money) {
        return createLottoes(getLottoCount(money));
    }

    public static int getLottoCount(int money) {
        return money / 1000;
    }

    private static List<Lotto> createLottoes(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto().createSixNumbers());
        }
        return lottos;
    }
}
