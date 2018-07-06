package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGame lottoGames = new LottoGame();

        List<Lotto> lottos = lottoGames.generate(inputView.inputMoney());
        outputView.printLottoList(lottos);

        lottoGames.setWinLotto(new Lotto(inputView.inputWinNumbers()));
        outputView.printResult(lottoGames.getLottoResult(lottos));
    }
}
