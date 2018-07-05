package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.util.LottoNumberUtil;

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
}
