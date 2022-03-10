package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Ticket implements Comparator<Ticket> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}
