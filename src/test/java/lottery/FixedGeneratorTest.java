package lottery;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FixedGeneratorTest {

    @Test
    public void generate() {
        FixedGenerator fixedGenerator = new FixedGenerator();
        assertThat(fixedGenerator.generate()).isInstanceOf(LottoNumber.class);
        for (int i = 0; i < 6; i++) {
            assertThat(fixedGenerator.generate().toInt()).isEqualTo(((i + 1) % 6)+1);
        }
    }

    @Test
    public void generate_입력받은값() {
        FixedGenerator fixedGenerator = new FixedGenerator(1,2,3,4,5,6);
        assertThat(fixedGenerator.generate()).isInstanceOf(LottoNumber.class);
        for (int i = 0; i < 6; i++) {
            assertThat(fixedGenerator.generate().toInt()).isEqualTo(((i + 1) % 6)+1);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void generate_입력받은값에러() {
        FixedGenerator fixedGenerator = new FixedGenerator(1,2,3,4,5);
        assertThat(fixedGenerator.generate()).isInstanceOf(LottoNumber.class);
        for (int i = 0; i < 6; i++) {
            assertThat(fixedGenerator.generate().toInt()).isEqualTo(((i + 1) % 6)+1);
        }
    }
}