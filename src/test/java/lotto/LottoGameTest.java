package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    private LottoGame lottoGame;

    @Before
    public void setUp() throws Exception {
        lottoGame = new LottoGame();
    }

    /**
     * Todo
     * 수익
     * Done
     * 로또리스트를 입력했을 때, 결과 리스트를 리턴
     */

    @Test
    public void get_로또_결과() {
        List<Lotto> lottos = Arrays.asList(LottoFactory.createFixedLotto("1,2,3,4,5,6"));
        Lotto winningLotto = LottoFactory.createFixedLotto("1,2,3,4,5,6");

        assertThat(lottoGame.getResult(lottos, winningLotto))
                .contains(new LottoResult(Match.THIRD ,0))
                .contains(new LottoResult(Match.FOURTH ,0))
                .contains(new LottoResult(Match.FIFTH ,0))
                .contains(new LottoResult(Match.SIXTH, 1));
    }

    @Test
    public void calculate_수익률() {
        assertThat(LottoGame.calculateYield(Arrays.asList(new LottoResult(Match.THIRD, 1)), 1000)).isEqualTo(500);
    }
}
