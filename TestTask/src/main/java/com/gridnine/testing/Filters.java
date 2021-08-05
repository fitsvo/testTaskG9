package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Filters implements FilterImpl{

    public static List<Flight> departureLate(List<Flight> Flights){
        List<Flight> filterFlights = new ArrayList<>();
        for (Flight flight: Flights) {
            for (Segment segment: flight.getSegments()) {
                LocalDateTime dateNow = LocalDateTime.now();
                LocalDateTime departureTime = segment.getDepartureDate();
                if (departureTime.isAfter(dateNow)) {
                    filterFlights.add(flight);
                    break;
                }
            }
        }
        System.out.println("Remove late flights:");
        System.out.println(filterFlights);
        return filterFlights;
    }

    public static List<Flight> departureError(List<Flight> Flights){
        List<Flight> filterFlights = new ArrayList<>();
        for (Flight flight: Flights) {
            for (Segment segment: flight.getSegments()) {
                LocalDateTime departureTime = segment.getDepartureDate();
                LocalDateTime arrivalTime = segment.getArrivalDate();
                if (departureTime.isBefore(arrivalTime))
                {
                    filterFlights.add(flight);
                    break;
                }
            }
        }
        System.out.println("Remove error departure:");
        System.out.println(filterFlights);
        return filterFlights;
    }

    public static List<Flight> longTransfer(List<Flight> Flights, int hour){
        List<Flight> filterFlights = new ArrayList<>();
        for (Flight flight: Flights) {
            List<Segment> segments = flight.getSegments();
            if (segments.size() == 1) filterFlights.add(flight);
            else
                for (int i = 0; i < segments.size() - 1; i++) {
                    LocalDateTime arrivalTime = segments.get(i).getArrivalDate();
                    LocalDateTime departureNextTime = segments.get(i + 1).getDepartureDate();
                    if (departureNextTime.isBefore(arrivalTime.plusHours(hour))) filterFlights.add(flight);
                }
        }
        System.out.println("Remove long transfer:");
        System.out.println(filterFlights);
        return filterFlights;
    }
    
}
