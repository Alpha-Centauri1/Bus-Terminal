/**
 * The bus class contains it's information like capacity, type of bus
 * @author Noah
 */
public class Bus {

    private int capacity;
    private int number;
    private final int BIG = 50;

    /**
     * default constructor
     * @param capacity for the Bus, is being used
     * @param number of the Bus, is being used
     */
    public Bus(Integer capacity, Integer number) {
        this.capacity = capacity;
        this.number = number;
    }

    /**
     * @return the capacity of the bus
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity of the bus is being set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the number of the bus
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number sets the number of the bus
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return boolean value which determines, if the bus is big
     */
    public boolean isBig() {
        return (capacity > BIG);
    }
}
