package lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void getWinnings() {
        Game g = new Game(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Map<Integer, Integer> map = g.match("4, 5, 6, 7, 8, 9");
        assertEquals(new Integer(1), map.get(3));
    }

    @Test
    public void getEmptyWinnings() {
        Game g = new Game(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Map<Integer, Integer> map = g.match("10, 11, 23, 7, 8, 9");
        assertEquals(4, map.size());
    }

    @Test
    public void getIntegers() {
        assertThat(Game.getIntegers("1, 2, 3, 4, 5, 6"))
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void countingWins() {
        Map<Integer, Integer> map = new HashMap<>();
        Game.addWins(3, map);
        assertEquals(new Integer(1), map.get(3));
    }

}
