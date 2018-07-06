package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {
    @Test
    public void match() {
        WinningTicket winningTicket = new WinningTicket(LottoNumber.listOf(1, 2, 3, 4, 7, 8));

        Ticket ticket1 = new Ticket(LottoNumber.listOf(1, 2, 13, 14, 15, 16));
        assertThat(ticket1.match(winningTicket)).isEqualTo(2);

        Ticket ticket2 = new Ticket(LottoNumber.listOf(1, 2, 3, 14, 15, 16));
        assertThat(ticket2.match(winningTicket)).isEqualTo(3);

        Ticket ticket3 = new Ticket(LottoNumber.listOf(1, 2, 3, 4, 5, 6));
        assertThat(ticket3.match(winningTicket)).isEqualTo(4);
    }
}