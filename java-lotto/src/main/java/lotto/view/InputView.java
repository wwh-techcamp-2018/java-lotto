package lotto.view;

import lotto.Lotto;
import lotto.resource.EarningRate;
import lotto.resource.LottoNumber;
import lotto.resource.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static Money inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(scanner.nextLine());
    }

    public static Money inputManualLotto() { //Positive로 int를 감싸야하나 Money 클래스와 유사하기 떄문에 Money를 사용했습니다.
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new Money(scanner.nextLine());
    }

    public static List<Lotto> inputManualLottoSet(Money trialNumber) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < trialNumber.getMoney(); i++) {
            lottos.add(Lotto.ofComma(scanner.nextLine()));
        }
        return lottos;
    }

    public static String inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static LottoNumber inputBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return LottoNumber.ofString(scanner.nextLine());
    }
}
