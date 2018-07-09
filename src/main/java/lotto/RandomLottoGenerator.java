package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    private static final List<Integer> lottoSheet;

    static {
        lottoSheet = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoSheet.add(i);
        }
    }

    @Override
    public Lotto generate() {
        Collections.shuffle(lottoSheet);
        return new Lotto(lottoSheet.stream()
                .limit(6).sorted()
                .map(LottoNo::of)
                .toArray(LottoNo[]::new));
    }

    @Override
    public List<Lotto> generate(int n) {
        List<Lotto> lottos = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lottos.add(generate());
        }
        return lottos;
    }
}
