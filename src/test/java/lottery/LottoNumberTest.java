package lottery;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoNumberTest {

    private LottoNumber lottoNumber;

    @Before
    public void setUp() {
        lottoNumber = new LottoNumber(45);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lottoNumberFailed() {
        new LottoNumber(46);
    }

    @Test
    public void lottoNumberSucceed() {
        assertThat(lottoNumber).isEqualTo(new LottoNumber(45));
    }
}