package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public class TicketByTravelTimeAscComparator implements Comparator<Ticket> {
        public int compare(Ticket o1, Ticket o2) {
            return o1.getTravelTime() - o2.getTravelTime();
        }
    }

    public Ticket[] searchAirport(String DepartureAirport, String ArrivalAirport, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAllAirport("LED", "AER")) {

            if (ticket.getDepartureAirport().equalsIgnoreCase(DepartureAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
            if (ticket.getArrivalAirport().equalsIgnoreCase(ArrivalAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}