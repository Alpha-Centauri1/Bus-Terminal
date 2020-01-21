import java.util.List;

public class Station {
    private String name;
    private List<Terminal> terminals;

    public Station(String name, List<Terminal> terminals) {
        this.name = name;
        this.terminals = terminals;
    }

    public int arrive(Trip trip) throws NoTerminalAvailableException{
        Terminal terminal = determineFreeTerminal(trip);
        terminal.arrive(trip);
        return terminal.getNumber();
    }

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

    public void departure(String terminalNumber) {

    }

    public void terminalStatus(String terminalNumber) {

    }

    public static class NoTerminalAvailableException extends Exception {
        public NoTerminalAvailableException() {
            super("For the time being are no terminals available!");
        }
    }
}
