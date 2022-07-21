package ru.netology.javaqa.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.domain.Ticket;
import ru.netology.javaqa.repository.TicketRepository;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 1300, "DME", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 1400, "VKO", "KZN", 100);
    Ticket ticket3 = new Ticket(3, 1450, "DME", "KZN", 145);
    Ticket ticket4 = new Ticket(4, 1100, "AAQ", "VKO", 230);
    Ticket ticket5 = new Ticket(5, 2700, "GOJ", "SVO", 180);
    Ticket ticket6 = new Ticket(6, 3200, "LED", "AER", 300);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test

    public void shouldGetAll() {
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = manager.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test

    public void shouldSearchOneTicket() {
        Ticket[] expected = new Ticket[]{ticket4};
        Ticket[] actual = manager.searchTicket("AAQ", "VKO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchSeveralTicket() {
        Ticket[] expected = new Ticket[]{ticket1, ticket3};
        Ticket[] actual = manager.searchTicket("DME", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldNotSearchTicket() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchTicket("AER", "KZN");

        Assertions.assertArrayEquals(expected, actual);

    }


}
