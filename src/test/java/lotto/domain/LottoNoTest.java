package lotto.domain;

import lotto.domain.LottoNo;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoTest {
    @Test(expected = IllegalArgumentException.class)
    public void invalidLottoNo() {
        new LottoNo(46);
    }
}
