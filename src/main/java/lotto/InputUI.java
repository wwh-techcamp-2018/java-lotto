package lotto;

import java.util.Scanner;

public class InputUI {
    private static Scanner scanner = new Scanner(System.in);

    public static int getForLottoMoney() {
        System.out.println("구입금액을 입력해 주세요");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static String getHitNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

}
