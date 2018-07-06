package lotto;

public class LottoMain {
    public static void main(String[] args) {
        Generator gn = new LottoGenerator();
        LottoFactory factory = new LottoFactory(gn);
        LottoPlay game = new LottoPlay(factory);
        LottoResult result = new LottoResult(); // 세팅

        game.buyLottos(Integer.parseInt(InputView.inputMoney())); // 로또 구매
        ResultView.printLottos(game); // 구매한로또 출력
        WinningLotto winningLotto = new WinningLotto(new Lotto(InputView.inputWinnerNumbers()));
        result.makeResult(game.getLottos(), winningLotto); // 당첨번호생성 후 결과 생성
        ResultView.printResult(result); // 당첨결과 출력
        ResultView.printBenefit(result, game); // 수익률 출력
    }
}
