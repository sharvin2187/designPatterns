package patterns.facade.orderinternals;

public class Inventory {
    public static void reserveASpot() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
    }
}
