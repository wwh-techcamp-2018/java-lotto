package view;

import lottery.Balance;
import lottery.Lotto;
import lottery.WinningLotto;

import java.util.Scanner;

public class InputView {
    static Scanner scanner;

    public static Balance inputBalance() {
        scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return new Balance(scanner.nextInt());
    }

    public static WinningLotto inputWinningLotto() {
        scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new WinningLotto(Lotto.of(scanner.nextLine()));
    }
}
