package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final int LIMIT_WINCOUNT = 6;

    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return (new Scanner(System.in)).nextLine();
    }

    public static List<Integer> inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        List<Integer> winNumbers = toIntegers(sc.nextLine().split(","));
        if (winNumbers.size() != LIMIT_WINCOUNT) {
            throw new IllegalArgumentException();
        }
        return winNumbers;
    }

    public static List<Integer> toIntegers(String[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(Integer.parseInt(numbers[i].trim()));
        }
        return list;
    }
}
