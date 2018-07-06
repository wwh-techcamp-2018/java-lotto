package lotto;

import org.junit.Test;

import static org.junit.Assert.*;

public class RankTest {
    @Test
    public void rank() {
        // input: matchCount, output: rank
        assertEquals(Rank.LOSER, Rank.getRank(2));
        assertEquals(Rank.FOURTH, Rank.getRank(3));
        assertEquals(Rank.THIRD, Rank.getRank(4));
        assertEquals(Rank.SECOND, Rank.getRank(5));
        assertEquals(Rank.FIRST, Rank.getRank(6));
    }
}