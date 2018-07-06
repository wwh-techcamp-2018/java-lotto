package lottery;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void getRatio() {
        user.buyLottery(14000);
        int profit = 20000;
        double ratio = 142.857;
        assertEquals(ratio, user.calcRatio(profit),0.001);
    }

    @Test
    public void getNumOfLotteries() {
        assertEquals(14, user.getNumOfLotteries(14000));
    }

}