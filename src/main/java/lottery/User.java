package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private final static int PERCENT = 100;

    private int money;
    private List<Lottery> lotteries;

    public User() {
        lotteries = new ArrayList<>();
    }

    private void setMoney(int money) {
        this.money = money;
    }

    public List<Lottery> buyLottery(int money) {
        setMoney(money);

        int numOfLotteries = getNumOfLotteries(money);
        for (int i = 0; i < numOfLotteries; i++) {
            lotteries.add(Lottery.createLottery(createLottoNumber()));
        }
        return lotteries;
    }

    public List<LottoNumber> createLottoNumber() {
        Collections.shuffle(LottoNumberSet.lottoNumber);
        List<LottoNumber> lotto = new ArrayList<>();
        List<Integer> lottoNumberList = LottoNumberSet.lottoNumber.subList(0, Lottery.COUNT_NUM);
        for (Integer i : lottoNumberList) {
            lotto.add(LottoNumberSet.lottoNumberMap.get(i));
        }
        return lotto;
    }

    public double calcRatio(int profit) {
        return (double)profit / money * PERCENT;
    }

    public int getNumOfLotteries(int money) {
        return money / Lottery.PRICE;
    }
}
