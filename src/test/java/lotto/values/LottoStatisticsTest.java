package lotto.values;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoStatisticsTest {
    @Test
    public void toStringTest() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 40"),
                new Lotto("1, 2, 3, 4, 5, 7"),
                new Lotto("1, 2, 3, 4, 39, 40"),
                new Lotto("1, 2, 3, 38, 39, 40")
        );
        Lotto winLotto = new Lotto("1, 2, 3, 4, 5, 6");

        WinningLotto winningLotto = new WinningLotto(winLotto, 7);
        LottoStatistics statistics = new LottoStatistics(lottoList, winningLotto);
        StringBuilder builder = new StringBuilder();

        builder.append(Rank.FIFTH.toString()).append("- 1개\n");
        builder.append(Rank.FOURTH.toString()).append("- 1개\n");
        builder.append(Rank.THIRD.toString()).append("- 1개\n");
        builder.append(Rank.SECOND.toString()).append("- 1개\n");
        builder.append(Rank.FIRST.toString()).append("- 1개\n");

        assertThat(statistics.toString()).isEqualTo(builder.toString());
    }
}