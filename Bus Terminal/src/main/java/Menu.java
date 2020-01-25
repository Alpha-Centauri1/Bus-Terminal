import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Trip> trips = new ArrayList<>();
    List<Bus> buses = new ArrayList<>();
    private Station station;
    Scanner in = new Scanner(System.in);

    public Menu() throws Exception {
        station = new Station.Builder()
                .setName("Zurich West")
                .withTerminals(Station.generateTerminals())
                .build();
        createObjects();
        for (Trip trip : trips) {
            station.departure(trip);
            station.arrive(trip);
        }
    }

    public void displayMenu() throws Exception {
        String input;

        do {
            System.out.print("====Bus Scheduler Menu====\n" +
                    "[1] Arrive\n" +
                    "[2] Depart\n" +
                    "[3] Display Board\n" +
                    "[x] Exit\n");
            input = in.nextLine();

            switch (input) {
                case "1":
                    arrive();
                    break;
                case "2":
                    depart();
                    break;
                case "3":
                    displayBoard();
                    break;
            }

        } while (!input.equals("x"));
    }

    private void arrive() throws Exception {
        System.out.println("\n===== Arrive =====\n");
        System.out.println("Please enter trip number: ");
        String input = in.nextLine();
        for (Trip trip : trips) {
            if (trip.getNumber().equals(input) && trip.isGone()) {
                int terminalNumber = station.arrive(trip);
                System.out.println("Bus arrived at terminal " + terminalNumber);
            }
        }
    }

    private void depart() throws Exception{
        System.out.println("\n===== Depart =====\n");
        System.out.println("Trip number: ");
        String input = in.nextLine();
        for (Trip trip : trips) {
            if (trip.getNumber().equals(input) && !trip.isGone()) {
                station.departure(trip);
                System.out.println(trip.getNumber() + " just departed for " + trip.getDestination());
            }
        }
    }

    public void createObjects() {
        try {
            Gson gson = new Gson();
            File jsonFileBus = new File("C:\\Users\\luca\\OneDrive - TBZ\\TBZ\\Informatik_Module\\M226\\Bus Terminal\\Project\\Bus Terminal\\src\\main\\resources\\Buses.json");
            JsonReader reader = new JsonReader(new FileReader(jsonFileBus));
            buses = gson.fromJson(reader, BUS_TYPE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Trip trip1 = new Trip("ZH12", "13:00", "15:20", buses.get(0), "Zurich", true);
        Trip trip2 = new Trip("BE34", "16:10", "18:45", buses.get(1), "Bern", true);
        Trip trip3 = new Trip("MU69", "08:25", "12:15", buses.get(2), "Munich", false);
        trips.add(trip1);
        trips.add(trip2);
        trips.add(trip3);
    }

    private int loopTerminals(Trip trip) {
        for (Terminal terminal : station.getAllOccupiedTerminals()) {
            if (terminal.getTrip().getNumber().equals(trip.getNumber())) {
                return terminal.getNumber();
            }
        }
        return 0;
    }

    private void displayBoard() throws Exception {
        String separation = new String(new char[84]).replace("\0", "=");

        String leftAlignFormat = "%-16s  %-20s  %-19s  %-12s  %-2d %n";

        System.out.format(separation + "%n");
        System.out.format("Destination       Departure Time        Arrival Time         Number        Terminal        %n");
        System.out.format(separation + "%n");
        for (Trip trip : trips) {
            if (!trip.isGone()) {
                System.out.format(leftAlignFormat, trip.getDestination(), trip.getDepartureTime(), trip.getArrivalTime(), trip.getNumber(), loopTerminals(trip));
            }
        }
        System.out.format(separation + "%n");
    }

    private static final Type BUS_TYPE = new TypeToken<List<Bus>>() {
    }.getType();
}
