package lotto;

import lotto.generator.LottoGenerator;
import lotto.resource.CustomDouble;
import lotto.resource.Positive;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public static List<Lotto> repeatGenerateLottoNumber(Positive tryNumber, LottoGenerator lottoGenerator) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < tryNumber.getNumber(); i++) {
            lottoList.add(new Lotto(lottoGenerator.generateNumber()));
        }
        return lottoList;
    }

    public static Positive getTryNumber(Positive price) {
        return new Positive(price.getNumber() / 1000);
    }

    public static List<Rank> confirmWinning(List<Lotto> lottoList, Lotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            ranks.add(Rank.valueOf(lotto.getEqualNumber(winningLotto).getNumber()));
        }
        return ranks;
    }

    public static CustomDouble getEarningsRate(Positive inputMoney, List<Rank> ranks) {
        CustomDouble customDouble = new CustomDouble(0);
        for (Rank rank : ranks) {
            customDouble = customDouble.add(rank.getWinningMoney());
        }
        return CustomDouble.getPercentage(customDouble, inputMoney);
    }
}
