package lotto.resource;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test(expected = IllegalArgumentException.class)
    public void 생성자TestFailWithLowerNumber() {
        LottoNumber.of(-1);
    }

    @Test
    public void ofTest() {
        assertThat(LottoNumber.of(3).getLottoNumber()).isEqualTo(3);
    }

    @Test
    public void ofStringTest() {
        assertThat(LottoNumber.ofString("3").getLottoNumber()).isEqualTo(3);
    }
}