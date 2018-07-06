package lotto;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printTickets(List<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }

    public static void printStatistics(LottoResult result) {
        Map<Integer, Integer> resultnum = result.getResult();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("당첨 통계\n ---------\n3개 일치 (5000원)- %d개\n", resultnum.get(3)));
        sb.append(String.format("4개 일치 (50000원)- %d개\n", resultnum.get(4)));
        sb.append(String.format("5개 일치 (1500000원)- %d개\n", resultnum.get(5)));
        sb.append(String.format("6개 일치 (2000000000원)- %d개\n", resultnum.get(6)));
        System.out.println(sb.toString());
    }

    public static void printRevenue(float revenue) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", revenue));
    }
}
