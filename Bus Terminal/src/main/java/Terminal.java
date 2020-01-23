/**
 * Terminal class which contains a specific trip
 * @author Noah
 */
public abstract class Terminal {

    private Integer number;
    public Trip trip;

    /**
     * default constructor
     * @param number functions as the ID
     */
    public Terminal(int number) {
        this.number = number;
    }

    /**
     * function sets trip to null
     */
    public void departure() {
        this.trip = null;
    }

    /**
     * @param trip gets set to trip from class Trip
     */
    public void arrive(Trip trip) {
        this.trip = trip;
    }

    /**
     * @return boolean value which tells, if it's available or not
     */
    public boolean isAvailable() {
        return (this.trip == null);
    }

    /**
     * @return number gets number
     */
    public Integer getNumber() {
        return number;
    }


    /**
     * @return trip gets trip from class Trip
     */
    public Trip getTrip() {
        return trip;
    }

    /**
     * @return gets the bus from class bus
     */
    public Bus getBus() {
        if (this.trip == null) {
            return null;
        }

        return trip.getBus();
    }
}

