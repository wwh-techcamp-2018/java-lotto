package lottery;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lottery.Lotto.LOTTO_PRICE;

public class LotteryMain {
    public static void main(String[] args) {
        int quantity = InputView.inputBalance().toInt() / LOTTO_PRICE ;

        BoughtLottoList lottoList = new BoughtLottoList();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto();
            lotto.draw();
            lottoList.add(lotto);
        }
        OutputView.showBoughtLottoList(lottoList.toDto());
    }
}
