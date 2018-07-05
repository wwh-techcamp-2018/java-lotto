package view;

import dto.BoughtLottoListDto;
import dto.LottoDto;
import lottery.LottoNumber;

import java.util.List;

import static lottery.LottoNumber.LOTTO_LENGTH;

public class OutputView {
    public static void showBoughtLottoList(BoughtLottoListDto boughtLottoListDto) {
        System.out.println(boughtLottoListDto.getLottoDtos().size()+"개를 구매했습니다.");
        for (LottoDto lottoDto : boughtLottoListDto.getLottoDtos()) {
            System.out.print("[");
            List<LottoNumber> lottoNumbers = lottoDto.getLottoNumbers();
            for (int i = 0; i < LOTTO_LENGTH - 1; i++) {
                System.out.print(lottoNumbers.get(i) + ", ");
            }
            System.out.println(lottoNumbers.get(LOTTO_LENGTH - 1) + "]");
        }
    }



}
