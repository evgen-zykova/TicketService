package ru.netology.javaqa.repository;

import ru.netology.javaqa.domain.Ticket;
import ru.netology.javaqa.exception.NotFoundException;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];


    public void save(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }


    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("The ticket with id: " + id + " not found");
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }
}



