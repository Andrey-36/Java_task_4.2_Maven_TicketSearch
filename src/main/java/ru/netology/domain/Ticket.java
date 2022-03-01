package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;

    @Override
    public int compareTo(Ticket o) {
//        return this.price - o.price;
        if (this.price == o.price) {
            return 0;
        } else if (this.price < o.price) {
            return -1;
        } else {
            return 1;
        }
    }
}
