package patterns.observer;

public interface ISubscriber {
    public void update(String stock, TradeType tradeType);
}
