package lotto;

import lotto.values.Lotto;
import lotto.values.Rank;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @Before
    public void setUp() throws Exception {
        lotto = new Lotto(Arrays.asList(6,3,2,4,5,1));
    }

    @Test
    public void match() {
        assertThat(lotto.match(new Lotto(Arrays.asList(1,4,3,2,5,6))))
                .isEqualTo(Rank.FIRST);
        assertThat(lotto.match(new Lotto(Arrays.asList(1,2,3,8,10,20))))
                .isEqualTo(Rank.FOURTH);
    }

    @Test (expected = IllegalArgumentException.class)
    public void moreThanSixNumber() {
        new Lotto(Arrays.asList(1,4,2,3,6,8,14));
    }


    @Test (expected = IllegalArgumentException.class)
    public void lottoNumberOver45() {
        new Lotto(Arrays.asList(1,4,2,3,6,46));
    }

    @Test
    public void testToString() {
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkDuplicateNumber() {
        new Lotto(Arrays.asList(1,1,2,3,4,5));
    }
}
