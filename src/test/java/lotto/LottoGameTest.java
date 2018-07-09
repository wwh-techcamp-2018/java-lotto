package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.LottoResult;
import lotto.domain.Prize;
import lotto.util.LottoNumberUtil;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    private static final LottoNo[] RESULT_NUMBERS = LottoNumberUtil.lottoNumbers(1, 2, 3, 7, 8, 9);
    private static final LottoNo[] LOTTO_NUMBERS = LottoNumberUtil.lottoNumbers(1, 2, 3, 4, 5, 6);
    private LottoGame game;

    @Before
    public void setUp() throws Exception {
        game = new LottoGame(1000, new FixedLottoGenerator(LottoNumberUtil.lottoNumbers(1, 2, 3, 7, 8, 9)));
    }

    @Test
    public void 수익률() {
        assertThat(game.result(new LottoResult(new Lotto(LOTTO_NUMBERS), LottoNo.of(7))).getProfit()).isEqualTo(500.0);
    }

    @Test
    public void makePrizeMap() {
        assertThat(game.makePrizeMap(new LottoResult(new Lotto(RESULT_NUMBERS), LottoNo.of(7))).get().get(Prize.FIRST)).isOne();
    }
}
