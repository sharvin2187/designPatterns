package patterns.observer;

import java.util.HashSet;
import java.util.Set;

public class EventListener {
    Set<ISubscriber> listeners = new HashSet<>();

    public void subscribe(ISubscriber subscriber) {
        listeners.add(subscriber);
    }

    public void unsubscribe(ISubscriber subscriber) {
        listeners.remove(subscriber);
    }

    public void updateAll(String stock, TradeType tradeType) {
        for(ISubscriber subscriber: listeners) {
            subscriber.update(stock, tradeType);
        }
    }
}
