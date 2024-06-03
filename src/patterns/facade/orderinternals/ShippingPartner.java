package patterns.facade.orderinternals;

public class ShippingPartner {
    public static void ship() {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
        }
    }
}
