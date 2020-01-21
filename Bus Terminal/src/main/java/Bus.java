public class Bus {

    private int capacity;
    private int number;
    private final int BIG = 50;

    public Bus(Integer capacity, Integer number) {
        this.capacity = capacity;
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBig() {
        return (capacity > BIG);
    }
}
