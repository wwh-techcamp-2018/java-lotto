package lottery;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User(14000);
    }

    @Test
    public void getRatio() {
        assertEquals(100, user.calcRatio(14000));
    }

    @Test
    public void getNumOfLotteries() {
        assertEquals(14, user.getNumOfLotteries());
    }
}