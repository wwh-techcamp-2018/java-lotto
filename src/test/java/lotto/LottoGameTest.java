package lotto;

import lotto.generator.FixLottoGenerator;
import lotto.resource.EarningRate;
import lotto.resource.LottoNumber;
import lotto.resource.Money;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void repeatGenerateLottoNumberTest() {
        assertThat(LottoGame.repeatGenerateLottoNumber(2).size()).isEqualTo(2);
    }

    @Test
    public void getTryNumberTest() {
        int tryNumber = LottoGame.getTryNumber(new Money(14000));
        assertThat(tryNumber).isEqualTo(14);
    }

    @Test
    public void cofirmWinningTest() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(Lotto.ofNumbers(1,2,3,4,5,6));
        lottoList.add(Lotto.ofComma("1,2,3,4, 6,7"));
        List<Rank> list = LottoGame.confirmWinning(lottoList, Lotto.ofNumbers(1,2,3,7,8,9));
        assertThat(list).containsExactly(Rank.valueOf(3), Rank.valueOf(4));
    }

    @Test
    public void getEarningsRateTest() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.valueOf(3));
        EarningRate earningsRate = LottoGame.getEarningsRate(new Money(14000), ranks);

        assertThat(EarningRate.round(earningsRate)).isEqualTo(new EarningRate(35.7));
    }
}
