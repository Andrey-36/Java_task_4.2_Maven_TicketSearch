package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket firstTicket = new Ticket(1, 5000, "LED", "GDZ", 240);
    private Ticket secondTicket = new Ticket(2, 3000, "VKO", "AER", 120);
    private Ticket thirdTicket = new Ticket(3, 4000, "GOJ", "AAQ", 180);

    @BeforeEach
    public void setUp() {
        manager.add(firstTicket);
        manager.add(secondTicket);
        manager.add(thirdTicket);
    }

    @Test
    void shouldAdd() {
        Ticket[] expected = {firstTicket, secondTicket, thirdTicket};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPrice() {
        Ticket[] expected = new Ticket[]{secondTicket, thirdTicket, firstTicket};
        Ticket[] actual = new Ticket[]{secondTicket, thirdTicket, firstTicket};

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Ticket expected = secondTicket;
        Ticket actual = repository.findById(2);

        assertEquals(expected, actual);
    }

    @Test
    void findByIdAboveArray() {
        repository.findById(4);

        Ticket expected = null;
        Ticket actual = repository.findById(4);
        assertEquals(expected, actual);
    }

    @Test
    void shouldSearchByAirport() {
        Ticket[] expected = {thirdTicket, firstTicket};
        Ticket[] actual = manager.searchAirport("LED", "AAQ");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        repository.removeById(3);

        Ticket[] expected = {firstTicket, secondTicket};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}