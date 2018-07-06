package lotto.domain;

import lotto.dto.LottoDTO;
import lotto.generator.RandomLottoGenerator;

import java.util.Map;
import java.util.TreeMap;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    LottoDTO lottoDTO;

    public LottoGame() {
        lottoDTO = new LottoDTO();
    }

    public void setMoney(int money) {
        lottoDTO.setMoney(money);
    }

    public int buyMaximumLottos() {
        int lottoAmount = lottoDTO.getMoney() / LOTTO_PRICE;
        for (int i = 0; i < lottoAmount; i++) {
            buyLotto();
        }
        return lottoAmount;
    }

    public void buyLotto() {
        lottoDTO.add(Lotto.of(new RandomLottoGenerator()));
    }

    public void buyLotto(String numbers) {
        lottoDTO.add(Lotto.of(numbers));
    }

    public void setWinLotto(Lotto winLotto) {
        lottoDTO.setWinLotto(winLotto);
    }

    public void calculateTotalPrize() {
        Lotto winLotto = lottoDTO.getWinLotto();

        int sum = 0;
        for (Lotto lotto : lottoDTO.getLottoList()) {
            int matchCount = lotto.match(winLotto);
            sum += Rank.prizeOf(matchCount);
        }

        lottoDTO.setTotalPrize(sum);
    }

    public void makeStatistics() {
        Map<Rank, Integer> statisticsMap = initStatisticsMap();

        Lotto winLotto = lottoDTO.getWinLotto();
        for (Lotto lotto : lottoDTO.getLottoList()) {
            int matchCount = lotto.match(winLotto);
            Rank rank = Rank.of(matchCount);
            statisticsMap.put(rank, statisticsMap.get(rank) + 1);
        }

        lottoDTO.setStatistics(statisticsMap);
    }

    private Map<Rank, Integer> initStatisticsMap() {
        Map<Rank, Integer> statisticsMap = new TreeMap<>();
        for (int i = 0; i < Rank.WIN_MAX; i++) {
            statisticsMap.put(Rank.of(i), 0);
        }
        return statisticsMap;
    }

    public void calculateEarningRate() {
        int investMoney = lottoDTO.getMoney();
        int totalPrize = lottoDTO.getTotalPrize();
        lottoDTO.setEarningRate(String.format("%.1f", ((double) totalPrize / investMoney) * 100));
    }

    public LottoDTO getLottoDTO() {
        return lottoDTO;
    }

}
