package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @Test
    public void 당첨_2등_테스트() {
        assertThat(Prize.valueOf(5, true)).isEqualTo(Prize.SECOND);
    }

    @Test
    public void 당첨_3등_테스트() {
        assertThat(Prize.valueOf(5, false)).isEqualTo(Prize.THIRD);
    }
}
