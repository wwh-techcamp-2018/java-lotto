package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public static List<Lotto> create(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
