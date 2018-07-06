package lotto;

import lotto.LottoNumber;
import org.junit.Test;

import static org.junit.Assert.*;

public class LottoNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void outOfRangeException() {
        new LottoNumber(46);
    }

    @Test
    public void equalsTest() {
        assertEquals(false, new LottoNumber(30).equals(new LottoNumber(40)));
        assertEquals(true, new LottoNumber(30).equals(new LottoNumber(30)));
    }
}