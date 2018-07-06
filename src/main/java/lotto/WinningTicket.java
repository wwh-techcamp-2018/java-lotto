package lotto;

import java.util.List;

public class WinningTicket {
    private Ticket ticket;

    public WinningTicket(List<LottoNumber> numbers) {
        this.ticket = new Ticket(numbers);
    }

    public int contains(LottoNumber lottoNumber) {
        return this.ticket.contains(lottoNumber);
    }
}
