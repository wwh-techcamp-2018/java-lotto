package lottery;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    private Lotto fixedLotto;
    private Lotto randomLotto;

    @Before
    public void setUp() throws Exception {
        fixedLotto = new Lotto(1, 2, 3, 4, 5, 6);
        randomLotto = new Lotto();
    }

    @Test
    public void lottoDraw() {
        randomLotto.draw();
        assertThat(randomLotto.getLotto().size()).isEqualTo(6);
    }
}