package lotto;

import lotto.Lotto;
import lotto.LottoNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LottoTest {
    List<LottoNumber> numbers;
    Lotto lotto;

    @Before
    public void setUp() throws Exception {
        numbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(3),
                new LottoNumber(10),
                new LottoNumber(20),
                new LottoNumber(30),
                new LottoNumber(40)
        );
        lotto = new Lotto(numbers);
    }

    @Test
    public void getLottoString() {
        assertEquals("[1, 3, 10, 20, 30, 40]", lotto.toString());
    }

    @Test
    public void matchCount() {
        Lotto a = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(4),
                new LottoNumber(10),
                new LottoNumber(12),
                new LottoNumber(20),
                new LottoNumber(44)
        ));
        Lotto b = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(4),
                new LottoNumber(10),
                new LottoNumber(11),
                new LottoNumber(23),
                new LottoNumber(43)
        ));
        assertEquals(3, a.matchCount(b));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkOverlappingNumbers() {
        new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        ));
    }
}