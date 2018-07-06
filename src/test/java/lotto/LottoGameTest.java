package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {
    private LottoGame game;

    @Before
    public void setUp() throws Exception {
        game = new LottoGame();
    }

    @Test
    public void buyTicket() {
        int budget = 3000;

        List<List<Integer>> testNumbers = new ArrayList<>();
        List<Integer> num1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> num2 = Arrays.asList(40, 41, 42, 43, 44, 45);
        List<Integer> num3 = Arrays.asList(15, 16, 17, 18, 19, 20);

        testNumbers.add(num1);
        testNumbers.add(num2);
        testNumbers.add(num3);


        ValueGenerator vg = new ExplicitValueGenerator(testNumbers);
        ValueGenerator vg2 = new ExplicitValueGenerator(testNumbers);
        List<Ticket> tickets = TicketFactory.createTicket(3, vg);
        assertThat(game.buyTicket(budget, vg2)).isEqualTo(tickets);
    }

    @Test
    public void matchTickets() {
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 40, 41);
        int budget = 3000;

        List<List<Integer>> testNumbers = new ArrayList<>();
        List<Integer> num1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> num2 = Arrays.asList(1, 2, 3, 43, 44, 45);
        List<Integer> num3 = Arrays.asList(15, 2, 3, 4, 40, 41);

        testNumbers.add(num1);
        testNumbers.add(num2);
        testNumbers.add(num3);

        ValueGenerator vg = new ExplicitValueGenerator(testNumbers);
        game.buyTicket(budget, vg);

        assertThat(game.matchTickets(new WinningTicket(LottoNumber.listOf(winningNumber))).getResult())
                .contains(entry(3, 1), entry(4, 1), entry(5, 1), entry(6, 0));
    }

    @Test
    public void calculateRevenue() {
        LottoResult lottoResult = new LottoResult(new int[]{1, 0, 0, 0});

        assertThat(LottoGame.calculateRevenue(14000, lottoResult)).isEqualTo((float) 5000 / 14000 * 100);
    }
}