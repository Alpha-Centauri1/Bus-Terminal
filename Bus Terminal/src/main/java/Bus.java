public class Bus {

    private int capacity;
    private int type;
    private final int BIG = 50;

    public Bus(Integer capacity, Integer type) {
        this.capacity = capacity;
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isBig() {
        return (capacity > BIG);
    }
}
