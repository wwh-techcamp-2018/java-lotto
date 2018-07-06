package lottery;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BalanceTest {
    @Test(expected = IllegalArgumentException.class)
    public void balance() {
        new Balance(999);
    }
}