package lotto;

import lotto.generator.LottoGenerator;
import lotto.resource.EarningRate;
import lotto.resource.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static List<Lotto> repeatGenerateLottoNumber(int tryNumber) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < tryNumber; i++) {
            lottoList.add(Lotto.ofAuto());
        }
        return lottoList;
    }

    public static int getTryNumber(Money price) {
        return price.getMoney() / 1000;
    }

    public static List<Rank> confirmWinning(List<Lotto> lottoList, Lotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            ranks.add(Rank.valueOf(lotto.getEqualNumber(winningLotto)));
        }
        return ranks;
    }

    public static EarningRate getEarningsRate(Money inputMoney, List<Rank> ranks) {
        Money earingMoney = new Money(0);
        for (Rank rank : ranks) {
            earingMoney = earingMoney.add(rank.getWinningMoney());
        }
        return EarningRate.getPercentage(earingMoney, inputMoney);
    }
}
