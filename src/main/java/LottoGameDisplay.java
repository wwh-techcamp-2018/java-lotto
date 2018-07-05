import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGameDisplay {
    Scanner scanner = new Scanner(System.in);
    LottoGame lottoGame;

    public LottoGameDisplay(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
        introduction();
        printResults();
    }

    public void introduction() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.valueOf(scanner.nextLine());
        System.out.println(String.format("%d개를 구매했습니다.", price / 1000));
        lottoGame.setCost(price);
        lottoGame.setLottoHolder(lottoGame.generateLottoHolder());
        printLottoHolder();
        System.out.println();

        getUsersNumbers();
    }

    public void getUsersNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputNumbers[] = scanner.nextLine().split(", ");
        List<LottoNumber> numbers = new ArrayList<>();
        for (String inputNumber : inputNumbers) {
            numbers.add(new LottoNumber(Integer.valueOf(inputNumber)));
        }
        lottoGame.setWinnerLotto(new Lotto(numbers));
    }

    public void printLottoHolder() {
        for (Lotto lotto : lottoGame.getLottoHolder()) {
            System.out.println(lotto.getLottoString());
        }
    }

    public String getResultString(int matchCount) {
        return String.format("%d개 일치 (%d원) - %d개",
                matchCount,
                Rank.getMatchingPrize(matchCount),
                lottoGame.getMatchCountNumber(matchCount));
    }

    public void printResults() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        for(int matchCount = 3; matchCount <= 6; matchCount++) {
            System.out.println(getResultString(matchCount));
        }
        System.out.println(String.format("총 수익률은 %d%%입니다.", lottoGame.getProfitRate()));
    }

    public void run() {

    }
}
