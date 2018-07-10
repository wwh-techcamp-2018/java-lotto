package lottery;

import dto.BoughtLottoListDto;
import dto.LottoDto;
import dto.ResultDto;

import java.util.*;

public class BoughtLottoList {

    private List<Lotto> lottos;

    public BoughtLottoList() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottoDtos() {
        return lottos;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public BoughtLottoListDto toDto() {
        BoughtLottoListDto boughtLottoListDto = new BoughtLottoListDto();
        for (Lotto lotto : lottos) {
            boughtLottoListDto.add(lotto.toDto());
        }
        return boughtLottoListDto;
    }

    public ResultDto toResultDto(WinningLotto winLotto, Balance balance) {
        Map<Rank, Integer> resultMap = new TreeMap<>();
        for (Lotto lotto : lottos) {
            buildResultMap(winLotto, resultMap, lotto);
        }
        return new ResultDto(resultMap, calculateEarningRate(resultMap, balance));
    }

    private void buildResultMap(WinningLotto winLotto, Map<Rank, Integer> resultMap, Lotto lotto) {
        Rank rank = lotto.match(winLotto);
        if (resultMap.containsKey(rank)) {
            resultMap.put(rank, resultMap.get(rank) + 1);
        }

        if (!resultMap.containsKey(rank)) {
            resultMap.put(rank, 1);
        }
    }

    private Float calculateEarningRate(Map<Rank, Integer> resultMap, Balance balance) {
        float prize = 0;
        for (Map.Entry<Rank, Integer> entry : resultMap.entrySet()) {
            prize += entry.getKey().getPrize() * entry.getValue();
        }
        return prize / balance.toFloat() * 100;
    }

}
