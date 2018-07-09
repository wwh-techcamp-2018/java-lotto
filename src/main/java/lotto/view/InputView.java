package lotto.view;

import lotto.domain.LottoNo;
import lotto.domain.LottoResult;
import lotto.util.StringUtil;

import java.util.Scanner;

public class InputView {


    public static LottoResult inputLottoResult() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return StringUtil.parseToLottoResult(new Scanner(System.in).nextLine(), inputBonusNumber());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static int inputSeedMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static int inputManualNumber(int money) {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        int manualNumber = new Scanner(System.in).nextInt();
        if (money / 1000 < manualNumber) {
            throw new IllegalArgumentException();
        }
        return manualNumber;
    }

    public static String[] inputManualLotto(int manualNumber) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        String[] lottoNumbers = new String[manualNumber];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < manualNumber; i++) {
            lottoNumbers[i] = scanner.nextLine();
        }
        return lottoNumbers;
    }
}
