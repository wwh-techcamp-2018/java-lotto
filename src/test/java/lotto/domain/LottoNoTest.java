package lotto.domain;

import lotto.domain.LottoNo;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoTest {
    @Test(expected = IllegalArgumentException.class)
    public void invalidLottoNoIsMoreThan45() {
        LottoNo.of(46);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidLottoNoIsLessThan1() {
        LottoNo.of(0);
    }
}
