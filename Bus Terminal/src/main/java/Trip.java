/**
 * The Class Trip defines the trip by things like departure- or arrival time
 * @author Noah
 */
public class Trip {
    private String number;
    private String departureTime;
    private String arrivalTime;
    private Bus bus;
    private String destination;
    private boolean isNational;
    private boolean isGone;

    /**
     * @param number functions as the
     * @param departureTime is the time when the bus will departure
     * @param arrivalTime is the time when the bus will arrive
     * @param bus is the bus which is being used
     */
    public Trip(String number, String departureTime, String arrivalTime, Bus bus, String destination, boolean isNational) {
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.bus = bus;
        this.destination = destination;
        this.isNational = isNational;
        this.isGone = false;
    }

    /**
     * Default constructor
     */
    public Trip() {

    }

    /**
     * @return the number of the trip
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number sets the number of the trip
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return gets the departure time of the bus
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * @param departureTime sets the departure time of the bus
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * @return gets the arrival time of the bus
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @param arrivalTime sets the arrival time of the bus
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @return the bus which comes from the getBus()
     */
    public Bus getBus() {
        return bus;
    }

    /**
     * @param bus sets the bus of the Bus class
     */
    public void setBus(Bus bus) {
        this.bus = bus;
    }

    /**
     * @return the destination which comes from the getDestination()
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination sets the bus of the destination class
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return true if the trip is national
     */
    public boolean isNational() {
        return isNational;
    }

    public boolean isGone() {
        return isGone;
    }

    public void setGone(boolean gone) {
        isGone = gone;
    }
}
