package lotto;

import lotto.values.Lotto;
import lotto.values.LottoStatistics;
import lotto.values.Rank;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {


    private List<Lotto> lottoList;
    private Lotto winLotto;
    private LottoStatistics statistics;

    @Before
    public void setUp() throws Exception {
        lottoList = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 24)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)),
                new Lotto(Arrays.asList(1, 2, 3, 7, 19, 27)),
                new Lotto(Arrays.asList(45, 44, 43, 42, 41, 40))
        );
        winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        statistics = LottoGame.calculateStatistics(lottoList, winLotto);
    }

    @Test
    public void calculateYield() {
        statistics = LottoGame.calculateStatistics(lottoList, winLotto);
        double yield = statistics.getYield();

        double totalPrice = Rank.FIRST.getPrice()
                + Rank.SECOND.getPrice()
                + Rank.THIRD.getPrice()
                + Rank.FOURTH.getPrice();
        assertThat(yield).isEqualTo(totalPrice / (lottoList.size() * LottoGame.LOTTO_PRICE) * 100);
    }

    @Test
    public void getRankCount() {
        assertThat(statistics.getCount(Rank.FIRST)).isOne();
        assertThat(statistics.getCount(Rank.SECOND)).isOne();
        assertThat(statistics.getCount(Rank.THIRD)).isOne();
        assertThat(statistics.getCount(Rank.FOURTH)).isOne();
        assertThat(statistics.getCount(Rank.MISS)).isOne();
    }

    @Test
    public void buyLotto() {
        List<Lotto> lottoList = LottoGame.buyLotto(14000);
        assertThat(lottoList).hasSize(14);
    }
}
