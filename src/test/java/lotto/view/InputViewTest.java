package lotto.view;

import org.assertj.core.util.Sets;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class InputViewTest {

    private InputView inputView;

    @Before
    public void setup() {
        inputView = new InputView();
    }

    @Test
    public void splitTest() {
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6"}, inputView.splitInputString("1, 2, 3, 4, 5, 6"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void splitExceptionTest() {
        inputView.splitInputString(null);
    }

    @Test
    public void parseTest() {
        assertThat(Sets.newHashSet(Arrays.asList(1, 2, 3, 4, 5, 6)), is(inputView.parse(new String[]{"1", "2", "3", "4", "5", "6"})));
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseNumberExceptionTest() {
        inputView.parse(new String[]{"[, 1"});
    }

}