package lotto.values;

import lotto.values.LottoNumber;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoNumberTest {
    @Test
    public void toInt() {
        LottoNumber number = new LottoNumber(2);
        int result = number.toInt();
        assertThat(result).isEqualTo(2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalidNumberUnder1() {
        new LottoNumber(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalidNumberOver45() {
        new LottoNumber(46);
    }
}
