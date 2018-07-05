package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void lottoSize() {
        Lotto lotto = new Lotto();
        assertEquals(6, lotto.getNumbers().size());
    }

    @Test
    public void createNumber() {
        List<Integer> nums = Lotto.createNumber();
        for (Integer num : nums) {
            assertTrue(num > 0 && num < 46);
        }
    }

    @Test
    public void selectNumber() {
        List<Integer> numbers = Lotto.createNumber();
        List<Integer> subNumbers = Lotto.selectNumber(numbers);
        assertEquals(6, subNumbers.size());
    }

    @Test
    public void sorting() {
        List<Integer> numbers = Arrays.asList(1, 2, 30, 10, 20, 3);
        List<Integer> cloned = new ArrayList<>(numbers);
        assertThat(Lotto.sorted(numbers)).doesNotContainSubsequence(cloned);
    }

    @Test
    public void checkExistCount() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 20, 30));
        List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 20, 30, 6);
        assertEquals(new Integer(5), lotto.existCount(winnerNumbers));

        winnerNumbers = Arrays.asList(1, 2, 3, 20, 7, 6);
        assertEquals(new Integer(4), lotto.existCount(winnerNumbers));

        winnerNumbers = Arrays.asList(1, 4, 5, 7, 9, 11);
        assertEquals(new Integer(1), lotto.existCount(winnerNumbers));


    }
}
