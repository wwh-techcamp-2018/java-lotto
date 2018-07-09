package lotto;

import lotto.values.Lotto;
import lotto.values.LottoNumber;
import lotto.values.Rank;
import lotto.values.WinningLotto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test (expected = IllegalArgumentException.class)
    public void duplicateBonusNumber() {
        new WinningLotto(new Lotto("1, 2, 3, 4, 5, 6"), 6);
    }

    @Test
    public void match() {
        Lotto secondPrice = new Lotto("1,2,3,4,5,6");
        WinningLotto winningLotto = new WinningLotto(new Lotto("1, 2, 3, 4, 5, 6"), 10);
        assertThat(winningLotto.match(secondPrice)).isEqualTo(Rank.FIRST);
    }


    @Test
    public void matchBonusNumber() {
        Lotto secondPrice = new Lotto("1,2,3,4,5,10");
        WinningLotto winningLotto = new WinningLotto(new Lotto("1, 2, 3, 4, 5, 6"), 10);
        assertThat(winningLotto.match(secondPrice)).isEqualTo(Rank.SECOND);
    }
}

