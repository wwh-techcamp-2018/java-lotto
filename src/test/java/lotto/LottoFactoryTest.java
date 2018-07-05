package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {
    /**
     * TODO
     *  1. 금액 입력 시 로또 배열 반환
     *  2. 로또 배열 한 개와 당첨 번호 입력 시 맞춘 개수 반환
     *
     *   당첨 번호와 로또 배열 입력 시 당첨 통계와 수익률 반환
     *
     * DONE
     */
    @Test
    public void checkLottoList() {
        assertThat(LottoFactory.createLotto(14000).size()).isEqualTo(14);
    }
}
