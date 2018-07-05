package lotto;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {


    private Lotto lotto;

    @Before
    public void setUp() throws Exception {
        lotto = new Lotto();
    }

    @Test
    public void create_로또_생성() {
        Lotto lotto = new Lotto();
        assertThat(lotto.createSixNumbers().getNumbers().size()).isEqualTo(6);
    }

    @Test
    public void create_당첨로또_생성() {
        String winNumbers = "1,2,3,4,5,6";
        assertThat(lotto.createWinLotto(winNumbers).getNumbers())
                .contains(1)
                .contains(2)
                .contains(3)
                .contains(4)
                .contains(5)
                .contains(6);
    }

    @Test
    public void get_일치_개수() {
        Lotto winnerLotto = new Lotto();
        winnerLotto.createWinLotto("1,2,3,4,5,6");

        Lotto testLotto = new Lotto();
        testLotto.createWinLotto("1,2,3,4,5,7");
        assertThat(testLotto.matchBy(winnerLotto)).isEqualTo(5);
    }
}