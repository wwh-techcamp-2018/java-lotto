package lotto;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {
    @Test
    public void match() {
        Ticket ticket = new Ticket(Arrays.asList(1,2,3,4,5,6));
        Ticket winningTicket = new Ticket(Arrays.asList(1,2,3,4,7,8));
        assertThat(ticket.match(winningTicket)).isEqualTo(4);
    }
}