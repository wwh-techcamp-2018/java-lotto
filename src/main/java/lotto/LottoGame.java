package lotto;

import lotto.util.MathUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int PRICE = 1000;

    private List<Ticket> tickets;

    public LottoGame() {
        tickets = new ArrayList<>();
    }

    public static float calculateRevenue(int budget, LottoResult lottoResult) {
        return MathUtil.getPercentage(lottoResult.getSum(), budget);
    }

    public List<Ticket> buyTicket(int budget, ValueGenerator vg) {
        this.tickets = TicketFactory.createTicket(budget / PRICE, vg);
        return this.tickets;
    }

    public LottoResult matchTickets(WinningTicket winningticket) {
        LottoResult result = new LottoResult();
        for (Ticket ticket : tickets) {
            result.addResult(ticket.match(winningticket));
        }

        return result;
    }
}
