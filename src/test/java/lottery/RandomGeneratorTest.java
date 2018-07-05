package lottery;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {

    @Test
    public void generate() {
        RandomGenerator randomGenerator = new RandomGenerator();
        assertThat(randomGenerator.generate()).isInstanceOf(LottoNumber.class);
    }
}