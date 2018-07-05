import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoGameTest {

    private LottoGame lottoGame;

    @Before
    public void setUp() throws Exception {
        lottoGame = new LottoGame();
    }

    @Test
    public void generateLottoHolder() {
        lottoGame.setCost(6000);
        assertEquals(6, lottoGame.generateLottoHolder().size());
        lottoGame.setCost(0);
        assertEquals(0, lottoGame.generateLottoHolder().size());
    }

    @Test
    public void calculatePrizeSum() {
        // input: lotto output: prizeSum
        Lotto winnerLotto = new Lotto(Arrays.asList(3,4,5, 11, 12, 13));

        lottoGame.setLottoHolder(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7))
        ));
        lottoGame.setWinnerLotto(winnerLotto);
        assertEquals(10000, lottoGame.getPrizeSum());
    }

    @Test
    public void getProfitRate() {
        lottoGame.setCost(14000);
        Lotto winnerLotto = new Lotto(Arrays.asList(3,4,5, 11, 12, 13));
        lottoGame.setWinnerLotto(winnerLotto);
        lottoGame.setLottoHolder(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        ));
        assertEquals(35, lottoGame.getProfitRate());
    }
}