package lottery;

import common.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final static int PERCENT = 100;

    private int money;
    private List<Lottery> lotteries;

    public User(int money){
        lotteries = new ArrayList<>();
        this.money = money;
    }

    public List<Lottery> buyLottery() {
        int numOfLotteries = getNumOfLotteries();
        for (int i = 0; i < numOfLotteries; i++) {
            lotteries.add(new Lottery(RandomNumberGenerator.createDistinctRandomNumList(Lottery.COUNT_NUM)));
        }
        return lotteries;
    }


    public int calcRatio(int profit) {
        return profit / money * PERCENT;
    }

    public int getNumOfLotteries() {
        return money / Lottery.PRICE;
    }
}
