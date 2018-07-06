package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGameDisplay {
    Scanner scanner = new Scanner(System.in);
    LottoGame lottoGame;

    public LottoGameDisplay() {

    }

    public void introduction() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.valueOf(scanner.nextLine());
        System.out.println(String.format("%d개를 구매했습니다.", price / 1000));

        lottoGame = new LottoGame(price);

        printLottoHolder();
        System.out.println();

    }

    public Lotto getUsersNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputNumbers[] = scanner.nextLine().split(", ");
        List<LottoNumber> numbers = new ArrayList<>();
        for (String inputNumber : inputNumbers) {
            numbers.add(new LottoNumber(Integer.valueOf(inputNumber)));
        }
        return new Lotto(numbers);
    }

    public void printLottoHolder() {
        for (Lotto lotto : lottoGame.getLottoHolder()) {
            System.out.println(lotto.toString());
        }
    }

    public String getResultString(int matchCount, Lotto winnersLotto) {
        return String.format("%d개 일치 (%d원) - %d개",
                matchCount,
                Rank.getRank(matchCount).getPrize(),
                lottoGame.getMatchCountNumber(matchCount, winnersLotto));
    }

    public void printResults() {
        Lotto winnersLotto = getUsersNumbers();

        System.out.println("\n당첨 통계");
        System.out.println("---------");
        for(int matchCount = 3; matchCount <= 6; matchCount++) {
            System.out.println(getResultString(matchCount, winnersLotto));
        }
        System.out.println(String.format("총 수익률은 %d%%입니다.", lottoGame.getProfitRate(winnersLotto)));
    }

    public void run() {
        introduction();
        printResults();
    }
}
