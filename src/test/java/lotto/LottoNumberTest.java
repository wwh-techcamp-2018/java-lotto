package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    public void 정상숫자() {
        LottoNumber number = new LottoNumber(45);
        LottoNumber target = new LottoNumber(45);
        assertThat(number).isEqualTo(target);
    }

    @Test (expected = IllegalArgumentException.class)
    public void 예외숫자() {
        LottoNumber number = new LottoNumber(0);
        LottoNumber target = new LottoNumber(0);
        assertThat(number).isEqualTo(target);
    }
}