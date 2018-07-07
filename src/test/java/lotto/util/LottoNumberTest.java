package lotto.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test (expected = RuntimeException.class)
    public void zeroLottoNumber() {
        LottoNumber.of(0);
    }

    @Test (expected = RuntimeException.class)
    public void overflowLottoNumber() {
        LottoNumber.of(46);
    }

    @Test
    public void isSame() {
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
    }

}