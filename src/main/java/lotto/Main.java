package lotto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int price = ConsoleInputView.getPrice();

        List<Lotto> lottos = LottoFactory.createLotto(price);
        ConsoleOutputView.printLottoesInfo(lottos);

        Lotto winnerLotto = new Lotto();
        winnerLotto.createWinLotto(ConsoleInputView.getWinNumbers());

        LottoGameResult lottoGameResult = new LottoGameResult();

        for (Lotto lotto : lottos) {
            lottoGameResult.addMatchCount(lotto.matchBy(winnerLotto));
        }


        ConsoleOutputView.printResult(lottoGameResult, price);

    }
}
