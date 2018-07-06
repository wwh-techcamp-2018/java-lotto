package lotto.view;

import lotto.Lotto;
import lotto.LottoGame;
import lotto.LottoResult;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        int price = ConsoleInputView.getPrice();

        LottoGame lottoGame = new LottoGame();

        List<Lotto> lottos = lottoGame.createLottos(price);
        ConsoleOutputView.printLottoesInfo(lottos);

        List<LottoResult> results = LottoGame.getResult(lottos, lottoGame.createWinningLotto(ConsoleInputView.getWinNumbers()));
        ConsoleOutputView.printResult(results, LottoGame.calculateYield(results, price));
    }
}