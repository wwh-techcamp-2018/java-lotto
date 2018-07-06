package lottery;

import java.util.*;

public class Lottery {

    public final static int COUNT_NUM = 6;
    public final static int PRICE = 1000;

    private List<LottoNumber> lottoNumbers;

    private Lottery(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lottery createLottery(List<LottoNumber> lottoNumberList) {
        return new Lottery(lottoNumberList);
    }

    public int getNumOfMatching(WinningLottery winningLottery) {
        long numOfMatching = winningLottery.getLottery().lottoNumbers.stream()
                .filter(winningNum -> lottoNumbers.contains(winningNum))
                .count();
        return (int) numOfMatching;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return Objects.equals(lottoNumbers, lottery.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (LottoNumber lottoNumber : lottoNumbers) {
            sb.append(lottoNumber);
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}

