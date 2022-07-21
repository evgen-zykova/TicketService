package ru.netology.javaqa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.domain.Ticket;
import ru.netology.javaqa.exception.NotFoundException;

public class TicketRepositoryTest {

    Ticket ticket1 = new Ticket(1, 1300, "DME", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 1400, "VKO", "KZN", 100);
    Ticket ticket3 = new Ticket(3, 1450, "DME", "KZN", 145);
    Ticket ticket4 = new Ticket(4, 1100, "AAQ", "VKO", 230);
    Ticket ticket5 = new Ticket(5, 2700, "GOJ", "SVO", 180);
    Ticket ticket6 = new Ticket(6, 3200, "LED", "AER", 300);

    @Test

    public void saveTicket() {
        TicketRepository repository = new TicketRepository();
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeById() {
        TicketRepository repository = new TicketRepository();
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);

        repository.removeById(ticket3.getId());

        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5, ticket6};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenNotFoundId() {
        TicketRepository repository = new TicketRepository();
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(10);
        });
    }
}
