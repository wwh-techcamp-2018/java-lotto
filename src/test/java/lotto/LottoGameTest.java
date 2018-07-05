package lotto;

import lotto.generator.FixLottoGenerator;
import lotto.resource.CustomDouble;
import lotto.resource.LottoNumber;
import lotto.resource.Positive;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    private LottoNumber[] lottoNumbers;
    private List<Lotto> lottoList;

    @Before
    public void setUp() throws Exception {
        lottoNumbers = new LottoNumber[6];
        for (int i = 0; i < lottoNumbers.length; i++) {
            lottoNumbers[i] = new LottoNumber(i + 1);
        }

        lottoList = LottoGame.repeatGenerateLottoNumber(new Positive(2), new FixLottoGenerator());
    }

    @Test
    public void repeatGenerateLottoNumberTest() {

        assertThat(lottoList).containsExactly(new Lotto(lottoNumbers), new Lotto(lottoNumbers));
    }

    @Test
    public void getTryNumberTest() {
        Positive p = LottoGame.getTryNumber(new Positive(14000));
        assertThat(p.getNumber()).isEqualTo(14);
    }

    @Test
    public void cofirmWinningTest() {
        List<Rank> list = LottoGame.confirmWinning(lottoList, lottoList.get(0));
        assertThat(list).containsExactly(Rank.valueOf(6), Rank.valueOf(6));
    }

    @Test
    public void getEarningsRateTest() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.valueOf(3));
        CustomDouble earningsRate = LottoGame.getEarningsRate(new Positive(14000), ranks);

        assertThat(CustomDouble.round(earningsRate)).isEqualTo(new CustomDouble(35.7));
    }
}
