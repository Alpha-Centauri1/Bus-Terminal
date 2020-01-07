import java.util.List;

public class Station {
    private String name;
    private List<Terminal> terminals;

    public Station() {

    }

    public int arrive(Trip trip) {
        for (int i = 0; i < terminals.size(); i++) {
            if (terminals.get(i).isAvailable()) {
                if (trip.isNational()) {
                    terminals.get(i).arrive(trip);
                    return i + 1;
                }else {
                    if (trip.getBus().isBig()){

                    }
                }

            }
        }
        return -1;
    }

    public void departure(String terminalNumber) {

    }

    public void terminalStatus(String terminalNumber) {

    }
}
