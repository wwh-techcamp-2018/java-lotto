package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test(expected = RuntimeException.class)
    public void factoryUnderTest() {
        Lotto.of("1,2,3,4,5");
    }

    @Test(expected = RuntimeException.class)
    public void factoryOverTest() {
        Lotto.of("1,2,3,4,5,6,7");
    }

    @Test
    public void match() {
        Lotto userLotto = Lotto.of("1,2,3,4,5,6");
        Lotto winLotto = Lotto.of(1, 2, 3, 14, 15, 16);
        int matchCount = userLotto.match(winLotto);
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    public void toStringTest() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
