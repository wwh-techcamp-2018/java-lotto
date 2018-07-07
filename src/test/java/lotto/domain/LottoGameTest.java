package lotto.domain;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void buyMaximumLottos() {
        LottoGame game = new LottoGame();
        game.setMoney(14000);
        assertThat(game.buyMaximumLottos()).isEqualTo(14);
    }

    @Test
    public void buyLotto() {
        LottoGame game = new LottoGame();
        game.buyLotto();
        assertThat(game.getLottoDTO().getLottoList().size()).isEqualTo(1);
    }

    @Test
    public void calculateTotalPrize() {
        LottoGame game = new LottoGame();

        game.buyLotto("40,41,42,43,44,45");
        game.buyLotto("1, 20, 21, 22, 23, 24");
        game.buyLotto("1, 2, 37, 42, 21, 23");
        game.buyLotto("1, 2, 3, 45, 44, 43");
        game.buyLotto("1, 2, 3, 4, 44, 45");
        game.buyLotto("1, 2, 3, 4, 5, 45");
        game.buyLotto("1,2,3,4,5,6");

        game.setWinLotto(Lotto.of("1,2,3,4,5,6"));

        game.calculateTotalPrize();

        assertThat(game.getLottoDTO().getTotalPrize()).isEqualTo(2001555000);
    }

    @Test
    public void makeStatistics() {
        LottoGame game = new LottoGame();
        game.buyLotto("1,2,3,4,5,6");
        game.setWinLotto(Lotto.of("1,2,3,11,12,13"));
        game.makeStatistics();

        Map<Rank, Integer> rank = new HashMap<>();
        rank.put(Rank.SIXTH, 0);
        rank.put(Rank.FIFTH, 0);
        rank.put(Rank.FOURTH, 1);
        rank.put(Rank.THIRD, 0);
        rank.put(Rank.SECOND, 0);
        rank.put(Rank.FIRST, 0);
        rank.put(Rank.FAIL, 0);
        assertThat(game.getLottoDTO().getStatistics()).isEqualTo(rank);
    }


    @Test
    public void calculateEarningRate() {
        LottoGame game = new LottoGame();

        game.setMoney(2000);
        game.buyLotto("11, 12, 13, 14, 15, 16");
        game.buyLotto("1,2,3,4,5,6");

        game.setWinLotto(Lotto.of("1,2,3,24,25,26"));

        game.calculateTotalPrize();
        game.calculateEarningRate();

        assertThat(game.getLottoDTO().getEarningRate()).isEqualTo("250.0");
    }

}
