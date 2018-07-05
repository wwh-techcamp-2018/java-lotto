package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> inputWinNumbers() {
        System.out.println("\n 지난 주 당첨 번호를 입력해 주세요.");
        return parse(scanner.nextLine().split(", "));
    }

    String[] splitInputString(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException();

        return input.split(", ");
    }

    public List<Integer> parse(String[] values) {
        List<Integer> result = new ArrayList<>();
        for (String value : values) {
            result.add(parseInteger(value));
        }
        return result;
    }

    private int parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 주지 말아요.");
        }
    }
}
