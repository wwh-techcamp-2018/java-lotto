package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {
    /**
     * TODO
     * DONE
     * 금액 입력 시 로또 리스트 반환
     */
    @Test
    public void checkLottoList() {
        assertThat(LottoFactory.createLottoList(14000).size()).isEqualTo(14);
    }
}
