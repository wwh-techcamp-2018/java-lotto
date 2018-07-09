package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static int getMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String getWinNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int getManualLottoNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int getBonusBallNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> getLottoStrings(int manualLottoNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottoStringList = new ArrayList<>();
        for (int i = 0; i < manualLottoNumber; i++) {
            lottoStringList.add(scanner.nextLine());
        }
        return lottoStringList;
    }
}
