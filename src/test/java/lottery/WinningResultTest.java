package lottery;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WinningResultTest {
    private WinningResult winningResult;

    @Before
    public void setUp() {
        winningResult = new WinningResult(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void isValidNumOfMathcing() {
        assertEquals(true, winningResult.isValidNumOfMathcing(4));
        assertEquals(false, winningResult.isValidNumOfMathcing(2));
        assertEquals(false, winningResult.isValidNumOfMathcing(7));
    }

    @Test
    public void calProfit() {
        int actual = winningResult.calcProfit(Arrays.asList(new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6))));
        assertEquals(200000000, actual);
    }
}