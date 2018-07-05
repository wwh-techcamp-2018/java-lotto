package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class LottoGameTest {

    private LottoGame game;

    @Before
    public void setup() {
        game = new LottoGame();
    }

    @Test
    public void generateTest() {
        assertEquals(2, game.generate(2000).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputExceptionTest() {
        game.generate(999);
    }


    @Test
    public void collectionShuffleStudyTest() {
        List<Integer> testCase = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);

        Collections.shuffle(testCase);
        assertThat(expected, not(testCase));
    }

    @Test
    public void getWinnersTest() {
        List<Lotto> testCase = new ArrayList<>(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 9, 8, 7, 11, 12))
        ));

        game.setWinLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Lotto> winners = game.getWinners(testCase);
        assertEquals(2, winners.size());
    }
}