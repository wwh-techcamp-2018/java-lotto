package lotto;

import java.util.Scanner;

public class InputUI {
    private Scanner scanner;

    public InputUI() {
        scanner = new Scanner(System.in);
    }

    public int getForLottoeMoney() {
        System.out.println("구입금액을 입력해 주세요");
        try {
//            return 10000;
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public String getHitNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
//        return "1, 2, 3, 4, 5, 6";
        return scanner.nextLine();
    }

}
