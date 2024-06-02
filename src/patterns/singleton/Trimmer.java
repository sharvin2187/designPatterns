package patterns.singleton;

public class Trimmer {
    public static final Trimmer INSTANCE;

    static {
        INSTANCE = new Trimmer();
    }

    public static Trimmer getInstance() {
        return INSTANCE;
    }

    public String trim(String input) {
        return input.trim();
    }

    private Trimmer() {
    }
}
