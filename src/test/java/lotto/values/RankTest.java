package lotto.values;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void valueOfFirst() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }


    @Test
    public void valueOfSecond() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void valueOfThird() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    public void valueOfFourth() {
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void valueOfFifth() {
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void valueOfMissByZero() {
        assertThat(Rank.valueOf(0, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
    }

    @Test
    public void valueOfMissByOne() {
        assertThat(Rank.valueOf(1, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS);
    }

    @Test
    public void valueOfMissByTwo() {
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS);
    }

    @Test
    public void getTotalPrice() {
        assertThat(Rank.FOURTH.getTotalPrice(2)).isEqualTo(Rank.FOURTH.getPrice()*2);
    }

    @Test
    public void toStringWhenRankIsSECOND() {
        assertThat(Rank.SECOND.toString()).isEqualTo("5개 일치, 보너스 볼 일치(30000000원)");
    }

    @Test
    public void toStringWhenRankIsNotSECOND() {

        assertThat(Rank.FIRST.toString()).isEqualTo("6개 일치(2000000000원)");
    }
}