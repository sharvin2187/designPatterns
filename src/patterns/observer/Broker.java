package patterns.observer;

// Class to be monitored
public class Broker {
    public EventListener ev;

    public Broker(EventListener ev) {
        this.ev = ev;
    }

    public void buy(String stock) {
        // do something
        ev.updateAll(stock, TradeType.BUY);
    }

    public void sell(String stock) {
        // do something
        ev.updateAll(stock, TradeType.SELL);
    }
}

