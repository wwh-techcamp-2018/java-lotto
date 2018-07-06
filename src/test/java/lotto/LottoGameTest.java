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
        LottoResult lotto3rdResult = new LottoResult(Match.THIRD ,0);
        LottoResult lotto4thResult = new LottoResult(Match.FOURTH ,0);
        LottoResult lotto5thResult = new LottoResult(Match.FIFTH ,0);
        LottoResult lotto6thResult = new LottoResult(Match.SIXTH, 1);

        List<Lotto> lottos = Arrays.asList(new Lotto("1,2,3,4,5,6"));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");

        assertThat(lottoGame.getResult(lottos, winningLotto))
                .contains(lotto3rdResult)
                .contains(lotto4thResult)
                .contains(lotto5thResult)
                .contains(lotto6thResult);
    }

    @Test
    public void calculate_수익률() {
        List<LottoResult> results = Arrays.asList(new LottoResult(Match.THIRD, 1));
        assertThat(lottoGame.calculateYield(results, 1000)).isEqualTo(5);
    }
}
