package lottery;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoNumberTest {
    @Test
    public void toInt() {
        assertThat(new LottoNumber(3).toInt()).isEqualTo(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rangeOverflow() {
        assertThat(new LottoNumber(46).toInt()).isEqualTo(46);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rangeUnderflow() {
        assertThat(new LottoNumber(0).toInt()).isEqualTo(0);
    }
}