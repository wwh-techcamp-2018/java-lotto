package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShuffleTest {
    @Test
    public void shuffleTest() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Collections.shuffle(integers);
        assertThat(integers).doesNotContainSubsequence(1, 2, 3, 4, 5, 6);
    }
}
