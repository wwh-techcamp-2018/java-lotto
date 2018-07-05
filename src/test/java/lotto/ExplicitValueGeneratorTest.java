package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExplicitValueGeneratorTest {
    @Test
    public void nextValueTest() {
        List<List<Integer>> testNumbers = new ArrayList<List<Integer>>();
        testNumbers.add(Arrays.asList(1,2,3,4,5,6));
        testNumbers.add(Arrays.asList(40,41,42,43,44,45));
        testNumbers.add(Arrays.asList(15,16,17,18,19,20));

        ExplicitValueGenerator evg = new ExplicitValueGenerator(testNumbers);
        assertThat(evg.nextValue()).isEqualTo(Arrays.asList(1,2,3,4,5,6));
        assertThat(evg.nextValue()).isEqualTo(Arrays.asList(40,41,42,43,44,45));
    }
}