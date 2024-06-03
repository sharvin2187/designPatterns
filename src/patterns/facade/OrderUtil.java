package patterns.facade;

import patterns.facade.orderinternals.Inventory;
import patterns.facade.orderinternals.ShippingPartner;
import patterns.facade.orderinternals.SupplyChain;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* This class simplifies making an order and abstracts a complex sequence of steps:
*  1: Getting status from a supplier
*  2: Putting the product in an inventory
*  3: Shipping the product
* */
public class OrderUtil {
    public static void order(int productId) throws ProductNotFoundException {
        // Fetch availability
        FutureTask<Boolean> availabilityFetcher = new FutureTask<>(()->SupplyChain.procure(productId));
        (new Thread(availabilityFetcher)).start();

        // Parallely reserve a spot in our inventory
        Thread inventoryReserver = new Thread(() -> Inventory.reserveASpot());
        inventoryReserver.start();

        // Wait for availability to get resolved
        Boolean productAvailable = false;
        try {
            productAvailable = availabilityFetcher.get();
        } catch (Exception e) {
            throw new ProductNotFoundException("Internal error: " + e.getMessage());
        }
        if(!productAvailable) {
            throw new ProductNotFoundException("Invalid productId");
        }

        // Wait for inventory spot
        try {
            inventoryReserver.join();
        } catch (Exception e) {
            throw new ProductNotFoundException("Internal error: " + e.getMessage());
        }

        // Wait for shipping
        ShippingPartner.ship();
    }
}
