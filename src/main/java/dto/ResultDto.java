package dto;

import lottery.Rank;

import java.util.Map;

public class ResultDto {
    private Map<Rank, Integer> result;
    private Float earningRate;

    public ResultDto(Map<Rank, Integer> result, Float earningRate) {
        this.result = result;
        this.earningRate = earningRate;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public Float getEarningRate() {
        return earningRate;
    }
}
