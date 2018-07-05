package lotto;

import lotto.generator.RandomLottoGenerator;

import java.util.*;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    List<Lotto> lottoList;

    public LottoGame() {
        lottoList = new ArrayList<>();
    }

    public int buyMaximumLottos(int money) {
        int lottoAmount = money / LOTTO_PRICE;
        for (int i = 0; i < lottoAmount; i++) {
            buyLotto();
        }
        return lottoAmount;
    }

    public void buyLotto() {
        lottoList.add(new Lotto(new RandomLottoGenerator()));
    }

    public void buyLotto(String numbers) {
        lottoList.add(new Lotto(numbers));
    }


    public int getTotalPrize(String winLottoNumbers) {
        int sum = 0;
        for (Lotto lotto : lottoList) {
            LottoPrize prize = new LottoPrize(lotto.getCorrectCount(winLottoNumbers));
            sum += prize.getPrize();
        }
        return sum;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public static String getEarningRate(int earnMoney, int investMoney) {
        return String.format("%.1f", ((double) earnMoney / investMoney) * 100);
    }

}
