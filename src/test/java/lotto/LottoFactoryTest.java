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
    public void create_자동_로또() {
        assertThat(LottoFactory.createAutoLotto().getNumbers().size()).isEqualTo(6);
    }

    @Test
    public void create_수동_로또() {
        assertThat(LottoFactory.createFixedLotto("1,2,3,4,5,6").getNumbers())
                .contains(new LottoNumber(1))
                .contains(new LottoNumber(2))
                .contains(new LottoNumber(3))
                .contains(new LottoNumber(4))
                .contains(new LottoNumber(5))
                .contains(new LottoNumber(6));
    }

    @Test
    public void create_로또_리스트() {
        assertThat(LottoFactory.createLottoList(14000).size()).isEqualTo(14);
    }

}
