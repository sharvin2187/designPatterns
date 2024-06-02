package test.observer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import patterns.observer.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ObserverTest {
    EventListener eventListener = new EventListener();
    BuySubscriber buySubscriber = new BuySubscriber();
    SellSubscriber sellSubscriber = new SellSubscriber();
    DellSubscriber dellSubscriber = new DellSubscriber();
    Broker broker;

    @BeforeAll
    public void setUp() {
        eventListener.subscribe(buySubscriber);
        eventListener.subscribe(sellSubscriber);
        eventListener.subscribe(dellSubscriber);
        broker = new Broker(eventListener);
    }

    @Test
    public void test_verifySubscriptionCounts() {
        broker.buy("GOOG");
        broker.buy("AMZN");
        broker.buy("AAPL");
        broker.sell("AAPL");
        broker.sell("GOOG");
        eventListener.unsubscribe(sellSubscriber);
        broker.sell("NFLX");
        broker.sell("DELL");
        broker.sell("DELL");
        broker.buy("DELL");

        assertEquals(buySubscriber.getBuyCount(), 4);
        assertEquals(sellSubscriber.getSellCount(), 2);
        assertEquals(dellSubscriber.getVolume(), 3);
    }
}
