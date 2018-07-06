package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test (expected = IllegalArgumentException.class)
    public void check_로또_번호() {
        assertThat(new LottoNumber(0));
    }
}