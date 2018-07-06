package lotto;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    private Lotto lotto;

    @Before
    public void setUp() throws Exception {
        lotto = LottoFactory().createLotto();
    }

    @Test
    public void create_로또_생성() {
        assertThat(new Lotto().getNumbers().size()).isEqualTo(6);
    }

    @Test
    public void create_당첨로또_생성() {
        assertThat(new Lotto("1,2,3,4,5,6").getNumbers())
                .contains(new LottoNumber(1))
                .contains(new LottoNumber(2))
                .contains(new LottoNumber(3))
                .contains(new LottoNumber(4))
                .contains(new LottoNumber(5))
                .contains(new LottoNumber(6));
    }

    @Test
    public void get_일치_개수() {
        Lotto lotto = new Lotto("1,2,3,4,5,7");
        Lotto winnerLotto = new Lotto("1,2,3,4,5,6");

        assertThat(lotto.matchCountBy(winnerLotto)).isEqualTo(5);
    }
}