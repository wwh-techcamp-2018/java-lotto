package view;

import lottery.Balance;

import java.util.Scanner;

public class InputView {
    public static Balance inputBalance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return new Balance(scanner.nextInt());
    }
}
