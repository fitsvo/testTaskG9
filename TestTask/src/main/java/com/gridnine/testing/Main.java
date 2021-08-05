package com.gridnine.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String filter;
            List<Flight> allResultFlights = FlightBuilder.createFlights();
            while(!(filter = reader.readLine()).equals("EXIT")){
                try{
                    Commands commands = Commands.valueOf(filter);
                    switch(commands) {
                        case ALL:
                            System.out.println("All Flights:");
                            allResultFlights = FlightBuilder.createFlights();
                            System.out.println(allResultFlights);
                            System.out.print("Please, enter your filter: ");
                            break;
                        case LATE:
                            allResultFlights = Filters.departureLate(allResultFlights);
                            break;
                        case ERROR:
                            allResultFlights = Filters.departureError(allResultFlights);
                            break;
                        case LONG_TRANSFER:
                            //BufferedReader readerHour = new BufferedReader(new InputStreamReader(System.in));
                            System.out.print("Please, enter the number of transfer hours: ");
                            Scanner scanner = new Scanner(System.in);
                            int hour = scanner.nextInt();
                            allResultFlights = Filters.longTransfer(allResultFlights, hour);
                            break;
                    }
                }
                catch(IllegalArgumentException e){
                    System.out.println("Please, enter correct command.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
