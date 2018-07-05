package lotto.view;

import lotto.domain.LottoResult;
import lotto.util.StringUtil;

import java.util.Scanner;

public class InputView {


    public static LottoResult inputLottoResult() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return StringUtil.parseToLottoResult(new Scanner(System.in).nextLine());
    }

    public static int inputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }
}
