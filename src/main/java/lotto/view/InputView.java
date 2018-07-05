package lotto.view;

import lotto.resource.Positive;

import java.io.IOException;
import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static Positive inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Positive(scanner.nextLine());
    }

    public static String inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
