package lotto.domain;

import lotto.FixedLottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.LottoResult;
import lotto.util.LottoNumberUtil;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    public static final LottoNo[] LOTTO_NUMBERS = LottoNumberUtil.lottoNumbers(1, 2, 3, 4, 5, 6);

    @Test
    public void generateLotto() {

        FixedLottoGenerator lg = new FixedLottoGenerator(LOTTO_NUMBERS);
        Lotto l = lg.generate();

        assertThat(l).isEqualTo(new Lotto(LOTTO_NUMBERS));
    }

    @Test(expected = RuntimeException.class)
    public void 로또_번호가_6개_미만() {
        new Lotto(LottoNumberUtil.lottoNumbers(1, 2, 3, 4, 5));
    }

    @Test(expected = RuntimeException.class)
    public void 로또_번호가_6개_초과() {
        new Lotto(LottoNumberUtil.lottoNumbers(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    public void toString_테스트() {
        assertThat(new Lotto(LOTTO_NUMBERS).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 로또_유사도() {
        assertThat(new Lotto(LOTTO_NUMBERS).countIntersection(new LottoResult(LOTTO_NUMBERS))).isEqualTo(6);
    }
}
