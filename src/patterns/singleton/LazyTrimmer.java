package patterns.singleton;

public class LazyTrimmer {

    private static class HOLDER {
        static final LazyTrimmer INSTANCE = new LazyTrimmer();
    }

    public static LazyTrimmer getInstance() {
        return HOLDER.INSTANCE;
    }

    public String trim(String input) {
        return input.trim();
    }

    private LazyTrimmer() {
    }
}
