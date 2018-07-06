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

    @Test
    public void of() {
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
        lotto.draw();
        assertThat(lotto.getLotto().size()).isEqualTo(6);
    }

    @Test
    public void match() {
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1, 2, 3, 4, 5, 31"));
        lotto.draw();
        winningLotto.draw();
        Rank rank = lotto.match(winningLotto);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }
}