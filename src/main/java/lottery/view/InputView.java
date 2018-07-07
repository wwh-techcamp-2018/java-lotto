package lottery.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner;
    public InputView(){scanner = new Scanner(System.in);}

    public String inputMoney(){
        System.out.println("구매금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public String inputWinningLottery(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return scanner.nextLine();
    }
}
