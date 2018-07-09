package lotto.values;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @Before
    public void setUp() throws Exception {
        lotto = new Lotto(Arrays.asList(6, 3, 2, 4, 5, 1));
    }

    @Test
    public void match() {
        assertThat(lotto.match(new Lotto(Arrays.asList(1, 4, 3, 2, 5, 6))))
                .isEqualTo(Rank.FIRST.getMatches());
        assertThat(lotto.match(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))))
                .isEqualTo(Rank.THIRD.getMatches());
        assertThat(lotto.match(new Lotto(Arrays.asList(1, 2, 3, 8, 10, 20))))
                .isEqualTo(Rank.FIFTH.getMatches());
    }

    @Test(expected = IllegalArgumentException.class)
    public void moreThanSixNumber() {
        new Lotto(Arrays.asList(1, 4, 2, 3, 6, 8, 14));
    }


    @Test(expected = IllegalArgumentException.class)
    public void lottoNumberOver45() {
        new Lotto(Arrays.asList(1, 4, 2, 3, 6, 46));
    }

    @Test
    public void testToString() {
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkDuplicateNumber() {
        new Lotto(Arrays.asList(1, 1, 2, 3, 4, 5));
    }

    @Test
    public void ofStringList() {
        List<String> stringList = Arrays.asList(
                "1,2,3,4,5,6",
                "1,2,3,7,8,9",
                "1,2,3,10,11,12"
        );

        assertThat(Lotto.ofStringList(stringList))
                .contains(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                        new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12))
                );
    }

    @Test
    public void numberIsFoundInLotto() {
        assertThat(lotto.hasNumber(6)).isTrue();
    }

    @Test
    public void numberIsNotFoundInLotto() {
        assertThat(lotto.hasNumber(7)).isFalse();
    }
}
