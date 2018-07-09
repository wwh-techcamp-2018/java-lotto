package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.util.LottoNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class FixedLottoGenerator implements LottoGenerator {

    private final LottoNo[] fixedNumbers;

    public FixedLottoGenerator() {
        this(LottoNumberUtil.lottoNumbers(1, 2, 3, 4, 5, 6));
    }

    public FixedLottoGenerator(LottoNo... numbers) {
        if (numbers.length != 6) throw new IllegalArgumentException();
        fixedNumbers = numbers;
    }

    @Override
    public Lotto generate() {
        return new Lotto(fixedNumbers);
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
