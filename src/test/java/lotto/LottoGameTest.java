package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void buyMaximumLottos() {
        LottoGame game = new LottoGame();
        int lottos = game.buyMaximumLottos(14000);
        assertThat(lottos).isEqualTo(14);
    }

    @Test
    public void getTotalPrize() {
        LottoGame game = new LottoGame();

        game.buyLotto("40,41,42,43,44,45");
        game.buyLotto("1, 20, 21, 22, 23, 24");
        game.buyLotto("1, 2, 37, 42, 21, 23");
        game.buyLotto("1, 2, 3, 45, 44, 43");
        game.buyLotto("1, 2, 3, 4, 44, 45");
        game.buyLotto("1, 2, 3, 4, 5, 45");
        game.buyLotto("1,2,3,4,5,6");

        int prize = game.getTotalPrize("1,2,3,4,5,6");
        assertThat(prize).isEqualTo(2001555000);
    }

    @Test
    public void getCorrectNum() {

    }

    @Test
    public void getEarningRate() {
        String rate = LottoGame.getEarningRate(5000,14000);
        assertThat(rate).isEqualTo("35.7");
    }

}
