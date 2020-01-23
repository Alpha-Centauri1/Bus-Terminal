/**
 * Terminal which is international. Extends the terminal class
 * @extends Terminal
 */
public class InternationalTerminal extends Terminal {

    public static final int SMALL = 0;
    public static final int LARGE = 1;

    private int size;

    /**
     * default constructor
     * @param number functions as the ID
     * @param size is the size of the bus
     */
    public InternationalTerminal(int number, int size) {
        super(number);
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
