import java.util.List;

/**
 * Station class is like a holder for all terminals
 * @author Noah
 */
public class Station {
    private String name;
    private List<Terminal> terminals;

    /**
     * default constructor
     * @param name of the station used
     * @param terminals of the list terminal used
     */
    public Station(String name, List<Terminal> terminals) {
        this.name = name;
        this.terminals = terminals;
    }

    /**
     * @param trip from class Trip used
     * @return the number of the terminal
     * @throws NoTerminalAvailableException on error
     */
    public int arrive(Trip trip) throws NoTerminalAvailableException{
        Terminal terminal = determineFreeTerminal(trip);
        terminal.arrive(trip);
        return terminal.getNumber();
    }

    /**
     * Function determines, if the terminal is free or not
     * @param trip of class Trip is used
     * @return terminal of terminals
     * @throws NoTerminalAvailableException on error
     */
    private Terminal determineFreeTerminal(Trip trip) throws NoTerminalAvailableException {
        for (short i = 0; i < terminals.size(); i++) {
            if (terminals.get(i).isAvailable()) {
                if (trip.isNational()) {
                    return terminals.get(i);
                } else {
                    if (terminals.get(i) instanceof InternationalTerminal && ((InternationalTerminal )terminals.get(i)).getSize() == InternationalTerminal.LARGE) {
                        return terminals.get(i);
                    }
                }
            }
        }
        throw new NoTerminalAvailableException();
    }

    /**
     * @param terminalNumber of terminal on departure
     */
    public void departure(String terminalNumber) {

    }

    /**
     * @param terminalNumber of terminal for status
     */
    public void terminalStatus(String terminalNumber) {

    }

    /**
     * Exception class which is called, when no terminal is available
     * Prints out error
     */
    public static class NoTerminalAvailableException extends Exception {
        public NoTerminalAvailableException() {
            super("For the time being are no terminals available!");
        }
    }
}
