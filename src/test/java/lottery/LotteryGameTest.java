package lottery;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LotteryGameTest {

    private LotteryGame lotteryGame;

    @Before
    public void setUp() throws Exception {
        lotteryGame = new LotteryGame();
    }

    @Test
    public void createWinningLottery() {
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), lotteryGame.createWinningLottery("1,2,3,4,5,6"));
    }


}