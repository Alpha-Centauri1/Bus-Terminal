import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Station class is like a holder for all terminals
 * @author Noah
 */
public class Station {

    public static final boolean AVAILABLE = true;
    public static final boolean OCCUPIED = false;

    private final String name;
    private final List<Terminal> terminals;

    public static class Builder {
        private String name;
        private List<Terminal> terminals;

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder withTerminals(List<Terminal> terminals) {
            this.terminals = terminals;
            return this;
        }

        public Station build(){
            return new Station(this);
        }
    }

    /**
     * private constructor can only be called through builder
     */
    private Station(Builder builder)
    {
        this.name = builder.name;
        this.terminals = builder.terminals;
    }

    public static List<Terminal> generateTerminals() {
        Terminal[] terminal = new Terminal[4];
        terminal[0] = new NationalTerminal(0);
        terminal[1] = new NationalTerminal(1);

        terminal[2] = new InternationalTerminal(2, InternationalTerminal.LARGE);
        terminal[3] = new InternationalTerminal(3, InternationalTerminal.SMALL);
        return Arrays.asList(terminal);
    }

    public Terminal getTerminal(int terminalNumber) throws InvalidTerminalNumberException {
        try {
            return terminals.get(terminalNumber);
        } catch (ArrayIndexOutOfBoundsException x) {
            throw new InvalidTerminalNumberException();
        }
    }

    /**
     * @param trip from class Trip used
     * @return the number of the terminal
     * @throws NoTerminalAvailableException on error
     */
    public int arrive(Trip trip) throws NoTerminalAvailableException{
        Terminal terminal = determineFreeTerminal(trip);
        terminal.arrive(trip);
        trip.setGone(false);
        return terminal.getNumber();
    }

    /**
     * Function determines, if the terminal is free or not
     * @param trip of class Trip is used
     * @return terminal of terminals
     * @throws NoTerminalAvailableException on error
     */
    public Terminal determineFreeTerminal(Trip trip) throws NoTerminalAvailableException {
        for (short i = 0; i < terminals.size(); i++) {
            if (terminals.get(i).isAvailable()) {
                if (trip.isNational()) {
                    terminals.get(i).arrive(trip);
                    return terminals.get(i);
                } else {
                    if (terminals.get(i) instanceof InternationalTerminal && ((InternationalTerminal )terminals.get(i)).getSize() == InternationalTerminal.LARGE) {
                        terminals.get(i).arrive(trip);
                        return terminals.get(i);
                    }
                }
            }
        }
        throw new NoTerminalAvailableException();
    }

    /**
     * @param trip of terminal on departure
     */
    public void departure(Trip trip) throws NoTerminalAvailableException {
        for (Terminal terminal : getAllOccupiedTerminals()) {
            if (terminal.getTrip().getNumber().equals(trip.getNumber())) {
                terminal.departure();
            }
        }
        trip.setGone(true);
    }

    public List<Terminal> getAllOccupiedTerminals() {
        List<Terminal> occupiedTerminals = new ArrayList<>();
        for (Terminal terminal : terminals) {
            if (!terminal.isAvailable()) {
                occupiedTerminals.add(terminal);
            }
        }

        return occupiedTerminals;
    }

    /**
     * @param terminalNumber of terminal for status
     */
    public boolean terminalStatus(int terminalNumber) {
        for (Terminal terminal : getAllOccupiedTerminals()) {
            if (terminal.getNumber().equals(terminalNumber)) {
                return OCCUPIED;
            }
        }

        return AVAILABLE;
    }

    /**
     * Exception class which is called, when no terminal is available
     * Prints out error
     */
    public static class NoTerminalAvailableException extends Exception {
        public NoTerminalAvailableException() {
            super("Currently there are no terminals available!");
        }
    }

    public static class InvalidTerminalNumberException extends Exception {
        public InvalidTerminalNumberException() {
            super("This terminal number doesn't exist!");
        }
    }
}
