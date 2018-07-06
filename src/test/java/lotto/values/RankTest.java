package lotto.values;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void valueOfFirst() {
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void valueOfSecond() {
        assertThat(Rank.valueOf(5)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void valueOfThird() {
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.THIRD);
    }

    @Test
    public void valueOfFourth() {
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void valueOfMissByZero() {
        assertThat(Rank.valueOf(0)).isEqualTo(Rank.MISS);
    }

    @Test
    public void valueOfMissByOne() {
        assertThat(Rank.valueOf(1)).isEqualTo(Rank.MISS);
    }

    @Test
    public void valueOfMissByTwo() {
        assertThat(Rank.valueOf(2)).isEqualTo(Rank.MISS);
    }

    @Test
    public void getTotalPrice() {
        assertThat(Rank.THIRD.getTotalPrice(2)).isEqualTo(Rank.THIRD.getPrice()*2);
    }
}