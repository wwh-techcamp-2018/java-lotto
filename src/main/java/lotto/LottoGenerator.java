package lotto;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoGenerator {
    Lotto generate();

    List<Lotto> generate(int n);
}
