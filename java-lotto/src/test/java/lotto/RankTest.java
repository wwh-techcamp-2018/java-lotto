package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void valueOfTest() {
        Rank rank = Rank.valueOf(3);
        assertThat(rank.getWinningMoney()).isEqualTo(5000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOfTestFail() {
        Rank.valueOf(8);
    }

    @Test
    public void valueOfTestSecond() {
        assertThat(Rank.valueOf(5,true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5,false)).isEqualTo(Rank.THIRD);
    }
}
