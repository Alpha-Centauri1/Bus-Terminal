public class Trip {
    private int number;
    private String departureTime;
    private String arrivalTime;
    private Bus bus;

    public Trip(Integer number, String departureTime, String arrivalTime, Bus bus) {
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.bus = bus;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public boolean isNational() {
        return (number < 1);
    }
}
