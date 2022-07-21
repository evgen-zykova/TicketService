package ru.netology.javaqa.manager;

import ru.netology.javaqa.domain.Ticket;
import ru.netology.javaqa.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] getAll() {
        return repository.findAll();
    }

    public Ticket[] searchTicket(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getDepartureAirport().contains(from) && ticket.getArrivalAirport().contains(to)) {
            return true;
        } else {
            return false;
        }
    }
}
