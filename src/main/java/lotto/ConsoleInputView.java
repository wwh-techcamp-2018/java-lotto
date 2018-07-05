package lotto;

import java.util.Scanner;

public class ConsoleInputView {

    private static Scanner sc = new Scanner(System.in);;

    public static int getPrice() {
        System.out.println("구입금액을 입력해주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static String getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }
}
