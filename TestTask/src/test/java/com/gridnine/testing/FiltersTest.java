package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class FiltersTest {

    @Test
    void departureLate_Not_Null() {
        List<Flight> expected = Filters.departureLate(FlightBuilder.createFlights());
        Assertions.assertNotNull(expected);
    }

    @Test
    void departureError_Not_Null() {
        List<Flight> expected = Filters.departureError(FlightBuilder.createFlights());
        Assertions.assertNotNull(expected);
    }

    @Test
    void longTransplant_Not_Null() {
        List<Flight> expected = Filters.longTransfer(FlightBuilder.createFlights(), 2);
        Assertions.assertNotNull(expected);
    }

    @Test
    void departureLate() {
        List<Flight> actual = Collections.emptyList();
        List<Flight> expected = Filters.departureLate(Collections.emptyList());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void departureError() {
        List<Flight> actual = Collections.emptyList();
        List<Flight> expected = Filters.departureError(Collections.emptyList());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void longTransplant() {
        List<Flight> actual = Collections.emptyList();
        List<Flight> expected = Filters.longTransfer(Collections.emptyList(), 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void departureLateCount() {
        int expected = Filters.departureLate(FlightBuilder.createFlights()).size();
        int actual = 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void departureErrorCount() {
        int expected = Filters.departureError(FlightBuilder.createFlights()).size();
        int actual = 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void longTransplantCount() {
        int expected = Filters.longTransfer(FlightBuilder.createFlights(), 2).size();
        int actual = 5;
        Assertions.assertEquals(expected, actual);
    }
}