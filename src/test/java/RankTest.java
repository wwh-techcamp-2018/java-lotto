import org.junit.Test;

import static org.junit.Assert.*;

public class RankTest {
    @Test
    public void rank() {
        // input: matchCount, output: rank
        assertEquals(-1, Rank.getRank(2));
        assertEquals(4, Rank.getRank(3));
        assertEquals(3, Rank.getRank(4));
        assertEquals(2, Rank.getRank(5));
        assertEquals(1, Rank.getRank(6));
    }

    @Test
    public void rankPrize() {
        // input: rank output: price
        assertEquals(0, Rank.getRankPrize(Rank.LOSER_RANK));
        assertEquals(5000, Rank.getRankPrize(4));
        assertEquals(50000, Rank.getRankPrize(3));
        assertEquals(1500000, Rank.getRankPrize(2));
        assertEquals(2000000000, Rank.getRankPrize(1));
    }
}