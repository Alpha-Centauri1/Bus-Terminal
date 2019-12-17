public class InternationalTerminal extends Terminal {

    public static final int SMALL = 0;
    public static final int LARGE = 1;

    private int size;

    public InternationalTerminal(int number, int size) {
        super(number);
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
