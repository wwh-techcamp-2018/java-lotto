package lottery;

import dto.ResultDto;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lottery.Lotto.LOTTO_PRICE;

public class LotteryMain {
    public static void main(String[] args) {
        Balance balance = InputView.inputBalance();
        BoughtLottoList lottoList = new BoughtLottoList();
        for (int i = 0; i < balance.toInt() / LOTTO_PRICE; i++) {
            Lotto lotto = new Lotto();
            lotto.draw();
            lottoList.add(lotto);
        }

        OutputView.showBoughtLottoList(lottoList.toDto());
        WinningLotto winningLotto = InputView.inputWinningLotto();
        winningLotto.draw();

        ResultDto resultDto = lottoList.toResultDto(winningLotto, balance);
        OutputView.showResult(resultDto);
    }
}
