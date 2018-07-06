package lotto;

import org.junit.Test;

public class LottoNumberTest {
    @Test (expected = IllegalArgumentException.class)
    public void check_로또_번호() {
        LottoNumber number = new LottoNumber(0);
    }
}