public abstract class Terminal {

    private Integer number;
    public Trip trip;

    public Terminal(int number) {
        this.number = number;
    }

    public void depature() {
        this.trip = null;
    }

    public void arrive(Trip trip) {
        this.trip = trip;
    }

    public boolean isAvailable() {
        return (this.trip == null);
    }

    public Integer getNumber() {
        return number;
    }

    public Trip getTrip() {
        return trip;
    }

    public Bus getBus() {
        if (this.trip == null) {
            return null;
        }

        return trip.getBus();
    }
}

