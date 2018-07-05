package lotto;

import lotto.util.mathUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int PRICE = 1000;
    private static final int PRIZE_3 = 5000;
    private static final int PRIZE_4 = 50000;
    private static final int PRIZE_5 = 1500000;
    private static final int PRIZE_6 = 2000000000;


    private List<Ticket> tickets;

    public LottoGame() {
        tickets = new ArrayList<>();
    }

    public static float calculateRevenue(int budget, LottoResult lottoResult) {
        int sum = 0;
        int[] result = lottoResult.getResult();
        sum += result[0] * PRIZE_3
                + result[1] * PRIZE_4
                + result[2] * PRIZE_5
                + result[3] * PRIZE_6;

        return mathUtil.getPercentage(sum, budget);
    }

    public List<Ticket> buyTicket(int budget, ValueGenerator vg) {
        this.tickets = TicketFactory.createTicket(budget / PRICE, vg);
        return this.tickets;
    }

    public LottoResult matchTickets(List<Integer> winningNumber) {
        LottoResult result = new LottoResult();
        for (Ticket ticket : tickets) {
            result.addResult(ticket.match(new Ticket(winningNumber)));
        }

        return result;
    }
}
