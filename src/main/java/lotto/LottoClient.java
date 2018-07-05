package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoClient {
    static final int LOTTO_PRICE = 1000;
    static Map<Integer, Integer> resultAwardMap;

    enum LOTTO_AWARDS {
        BASIC(5000, 50000, 1500000, 2000000000);

        private int three_correct;
        private int four_correct;
        private int five_correct;
        private int six_correct;

        LOTTO_AWARDS(int three_correct, int four_correct, int five_correct, int six_correct) {
            this.three_correct = three_correct;
            this.four_correct = four_correct;
            this.five_correct = five_correct;
            this.six_correct = six_correct;
        }

        public int getThree_correct() {
            return three_correct;
        }

        public int getFour_correct() {
            return four_correct;
        }

        public int getFive_correct() {
            return five_correct;
        }

        public int getSix_correct() {
            return six_correct;
        }
    }

    static {
        LOTTO_AWARDS basicAwards = LOTTO_AWARDS.BASIC;
        resultAwardMap = new TreeMap<Integer, Integer>();
        resultAwardMap.put(3, basicAwards.getThree_correct());
        resultAwardMap.put(4, basicAwards.getFour_correct());
        resultAwardMap.put(5, basicAwards.getFive_correct());
        resultAwardMap.put(6, basicAwards.getSix_correct());
    }

    public static void main(String[] args) {
        InputUI inputUI = new InputUI();1000
        Money money = new Money(inputUI.getForLottoeMoney());
        List<Lotto> lottoes = new LottoFactory().createLotto(maxLottoToBuy(money));

        ResultUI resultUI = new ResultUI();

        resultUI.printBuyedLottoes(
                lottoes.stream()
                        .map(x -> x.toString())
                        .collect(Collectors.toList()));

        HitNumber hitNumber = new HitNumber(inputUI.getHitNumber());

        List<Integer> results = calculateResults(lottoes, hitNumber);

        for (Integer numOfHits : resultAwardMap.keySet()) {
            resultUI.printResultStatics2(
                    numOfHits,
                    resultAwardMap.get(numOfHits),
                    Collections.frequency(results, numOfHits)
            );
        }

        resultUI.printBenefitRate(calculateBenefitRate(lottoes, hitNumber));
    }


    public static double calculateBenefitRate(List<Lotto> lottoes, HitNumber hitNumber) {
        List<Integer> lottoResults = calculateResults(lottoes, hitNumber);
        return calculateTemplate(lottoResults);
    }

    public static double calculateTemplate(List<Integer> lottoResults) {
        double sum = 0;
        for (int result : lottoResults) {
            if (resultAwardMap.containsKey(result))
                sum += resultAwardMap.get(result);
        }
        return userFloor(sum / (lottoResults.size() * LOTTO_PRICE) * 100);
    }

    public static double userFloor(double target) {
        int intTarget = (int) (target * 10);
        return intTarget / 10.0;
    }

    static List<Integer> calculateResults(List<Lotto> lottoes, HitNumber hitNumber) {
        List<Integer> results = new ArrayList<Integer>();
        for (Lotto lotto : lottoes) {
            results.add(lotto.compareLotto(hitNumber));
        }
        return results;
    }

    public static int maxLottoToBuy(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }
}
