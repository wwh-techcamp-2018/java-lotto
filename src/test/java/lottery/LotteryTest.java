package lottery;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LotteryTest {

    private Lottery lottery;

    @Before
    public void setup() {
        lottery = new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void makeLottery() {
        assertEquals(new Lottery(Arrays.asList(1, 2, 3, 4, 5, 6)), lottery);
    }

    @Test
    public void getNumOfMatching() {
        List<Integer> winningLottery = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(6, lottery.getNumOfMatching(winningLottery));
    }
}
