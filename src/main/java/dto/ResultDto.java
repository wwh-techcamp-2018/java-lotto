package dto;

import lottery.EarningRate;
import lottery.Rank;

import java.util.Map;

public class ResultDto {
    private Map<Rank, Integer> result;
    private EarningRate earningRate;

    public ResultDto(Map<Rank, Integer> result, EarningRate earningRate) {
        this.result = result;
        this.earningRate = earningRate;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public EarningRate getEarningRate() {
        return earningRate;
    }
}
