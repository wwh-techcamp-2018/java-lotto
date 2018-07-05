package lotto.resource;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    public void 생성자Test() {
        LottoNumber n = new LottoNumber(1);
        assertThat(n.getLottoNumber()).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성자TestFailWithUpperNumber() {
        new LottoNumber(46);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성자TestFailWithLowerNumber() {
        new LottoNumber(-1);
    }
}