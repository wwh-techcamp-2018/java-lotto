package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.*;

public class LottoDTO {

    private Map<Rank, Integer> statistics;
    private List<Lotto> lottoList;
    private Lotto winLotto;

    private int money;
    private int totalPrize;
    private String earningRate;

    public LottoDTO() {
        this.lottoList = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottoList.add(lotto);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Map<Rank, Integer> getStatistics() {
        return statistics;
    }

    public void setStatistics(Map<Rank, Integer> statistics){
        this.statistics = statistics;
    }

    public Lotto getWinLotto() {
        return this.winLotto;
    }

    public void setWinLotto(Lotto winLotto) {
        this.winLotto = winLotto;
    }

    public int getMoney() { return money; }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public void setTotalPrize(int totalPrize) {
        this.totalPrize = totalPrize;
    }

    public String getEarningRate() {
        return this.earningRate;
    }

    public void setEarningRate(String earningRate) { this.earningRate = earningRate; }

}
