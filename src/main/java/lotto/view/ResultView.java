package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.LottoDTO;

import java.util.Map;

public class ResultView {

    private LottoDTO lottoDTO;

    public ResultView(LottoDTO lottoDTO) {
        this.lottoDTO = lottoDTO;
    }

    public void printLottoList() {
        System.out.println(lottoDTO.getLottoList().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoDTO.getLottoList()) {
            System.out.println(lotto);
        }
    }

    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<Rank, Integer> statistics = lottoDTO.getStatistics();

        for (int i = Rank.WIN_MIN; i < Rank.WIN_MAX; i++) {
            Rank rank = Rank.of(i);
            System.out.println(String.format("%s - %d개", rank, statistics.get(rank)));
        }
    }

    public void printRate() {
        System.out.println("총 수익률은 " + lottoDTO.getEarningRate() + "%입니다.");
    }

}
