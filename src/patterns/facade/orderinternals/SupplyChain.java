package patterns.facade.orderinternals;

public class SupplyChain {
    public static boolean procure(int productId) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        if (productId < 0 || productId > 100) {
            return false;
        }
        return true;
    }
}
