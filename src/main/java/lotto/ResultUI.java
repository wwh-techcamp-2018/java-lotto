package lotto;

import java.util.List;

public class ResultUI {

    public static void printBuyedLottoes(List<String> lottoes) {
        System.out.printf("%d개를 구매했습니다.\n", lottoes.size());
        for (String lotto : lottoes)
            System.out.println(lotto);
    }

    public static void printResultStatics(int numOfHits, int prize, int numOfPrizes) {
        System.out.printf("%d개 일치 (%d원)- %d개\n", numOfHits, prize, numOfPrizes);
    }

    public static void printBenefitRate(double benefitRate) {
        System.out.printf("총 수익률은 %.1f%% 입니다.\n", benefitRate);
    }
}
