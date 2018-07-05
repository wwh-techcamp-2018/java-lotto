package lotto;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public String inputMessage() {
        return "구입금액을 입력해 주세요.";
    }

    public int inputMoney() {
        return scanner.nextInt();
    }

    public String lastWeekMessage() {
        return "지난 주 당첨 번호를 입력해 주세요.";
    }

    public String[] lastWeekWinLotto() {
        scanner.nextLine();
        return scanner.nextLine().split(",");
    }


}
