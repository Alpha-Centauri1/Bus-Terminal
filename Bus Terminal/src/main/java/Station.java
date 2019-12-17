import java.util.List;

public class Station {
    private String name;
    private List<String> terminals;

    public Trip arrive(Trip trip){
        return trip;
    }

    public Integer departure(String terminalNumber){

        return 4;
    }

    public Integer terminalStatus(String terminalNumber){

        return 1;
    }
}
