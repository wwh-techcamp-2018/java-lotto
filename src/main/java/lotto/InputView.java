package lotto;

import java.util.Scanner;

public class InputView {
    public static Integer getMoney() {
        Scanner s = new Scanner(System.in);
        System.out.println("구매금액을 입력해주세요.");
        return s.nextInt();
    }


    public static String getWinsNumber() {
        Scanner s = new Scanner(System.in);
        System.out.println("당첨 번호를 입력하세요.");
        return s.nextLine();
    }
}
