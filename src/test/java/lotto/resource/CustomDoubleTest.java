package lotto.resource;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomDoubleTest {

    @Test
    public void addTest() {
        CustomDouble customDouble = new CustomDouble(3.5);
        customDouble = customDouble.add(3);

        assertThat(customDouble).isEqualTo(new CustomDouble(6.5));
    }

    @Test
    public void round() {
        CustomDouble customDouble = CustomDouble.round(new CustomDouble(27.4356));
        assertThat(customDouble).isEqualTo(new CustomDouble(27.4));
    }

    @Test
    public void getPercentage() {
        CustomDouble customDouble = new CustomDouble(100.0);
        customDouble = CustomDouble.getPercentage(customDouble, new Positive(10));
        assertThat(customDouble).isEqualTo(new CustomDouble(1000.0));
    }
}