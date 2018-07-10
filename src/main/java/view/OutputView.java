package view;

import dto.BoughtLottoListDto;
import dto.LottoDto;
import dto.ResultDto;
import lottery.LottoNumber;
import lottery.Rank;

import java.util.List;
import java.util.Map;

import static lottery.LottoNumber.LOTTO_LENGTH;

public class OutputView {
    public static void showBoughtLottoList(BoughtLottoListDto boughtLottoListDto) {
        System.out.println(boughtLottoListDto.getLottoDtos().size() + "개를 구매했습니다.");
        for (LottoDto lottoDto : boughtLottoListDto.getLottoDtos()) {
            System.out.print("[");
            List<LottoNumber> lottoNumbers = lottoDto.getLottoNumbers();
            for (int i = 0; i < LOTTO_LENGTH - 1; i++) {
                System.out.print(lottoNumbers.get(i) + ", ");
            }
            System.out.println(lottoNumbers.get(LOTTO_LENGTH - 1) + "]");
        }
    }

    public static void showResult(ResultDto resultDto) {
        Map<Rank, Integer> result = resultDto.getResult();
        System.out.println("당첨 통계");
        System.out.println("--------------");
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey().getNumMatched() + "개 일치 (" + entry.getKey().getPrize() + "원) - " + entry.getValue() + "개");
        }
        Float earningRate = resultDto.getEarningRate();
        System.out.format("총 수익률은 %.1f%% 입니다.", earningRate);
    }


}
