package lotto.values;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoStatisticsTest {
    @Test
    public void toStringTest() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 40"),
                new Lotto("1, 2, 3, 4, 39, 40"),
                new Lotto("1, 2, 3, 38, 39, 40")
        );
        Lotto winLotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoStatistics statistics = new LottoStatistics(lottoList, winLotto);
        StringBuilder builder = new StringBuilder();

        builder.append(Rank.FOURTH.getMatches()).append("개 일치(").append(Rank.FOURTH.getPrice()).append("원)- 1개\n");
        builder.append(Rank.THIRD.getMatches()).append("개 일치(").append(Rank.THIRD.getPrice()).append("원)- 1개\n");
        builder.append(Rank.SECOND.getMatches()).append("개 일치(").append(Rank.SECOND.getPrice()).append("원)- 1개\n");
        builder.append(Rank.FIRST.getMatches()).append("개 일치(").append(Rank.FIRST.getPrice()).append("원)- 1개\n");

        assertThat(statistics.toString()).isEqualTo(builder.toString());
    }
}