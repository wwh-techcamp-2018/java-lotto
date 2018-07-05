import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LottoTest {
    List<Integer> numbers;
    Lotto lotto;
    @Before
    public void setUp() throws Exception {
       numbers = new ArrayList<>();
       numbers.add(1);
       numbers.add(3);
       numbers.add(10);
       numbers.add(20);
       numbers.add(30);
       numbers.add(40);
       lotto = new Lotto(numbers);
    }

    @Test
    public void getLottoString() {
        assertEquals("[1, 3, 10, 20, 30, 40]",lotto.getLottoString());;
    }

    @Test
    public void matchCount() {
        Lotto lottoA = new Lotto(Arrays.asList(1, 4, 10, 12, 20, 44));
        Lotto lottoB = new Lotto(Arrays.asList(1, 4, 10, 11, 23, 43));

        assertEquals(3, lottoA.matchCount(lottoB));
    }

    @Test
    public void checkWithinRange() {
        Lotto lottoA = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(true, lottoA.isValid());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkRangeException() {
        new Lotto(Arrays.asList(1, 50, 3, 4, 5, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkOverlappingNumbers() {
        new Lotto(Arrays.asList(1, 1, 2, 3, 4, 5));
    }
}