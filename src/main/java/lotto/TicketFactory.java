package lotto;

import java.util.ArrayList;
import java.util.List;

public class TicketFactory {

    public static List<Ticket> createTicket(int count, ValueGenerator vg) {
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (int i = 0; i < count; i++) {
            tickets.add(new Ticket(LottoNumber.listOf(vg.nextValue())));
        }
        return tickets;
    }
}
