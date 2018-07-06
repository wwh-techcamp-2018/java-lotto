package lotto.resource;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomDoubleTest {

    @Test
    public void addTest() {
        EarningRate customDouble = new EarningRate(3.5);
        customDouble = customDouble.add(3);

        assertThat(customDouble).isEqualTo(new EarningRate(6.5));
    }

    @Test
    public void round() {
        EarningRate customDouble = EarningRate.round(new EarningRate(27.4356));
        assertThat(customDouble).isEqualTo(new EarningRate(27.4));
    }

    @Test
    public void getPercentage() {
        EarningRate earningRate = new EarningRate(100.0);
        earningRate = EarningRate.getPercentage(earningRate, new EarningRate(10));
        assertThat(earningRate).isEqualTo(new EarningRate(1000.0));
    }
}