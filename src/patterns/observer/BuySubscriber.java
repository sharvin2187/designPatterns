package patterns.observer;

public class BuySubscriber implements ISubscriber {
    int buyCount;

    @Override
    public void update(String stock, TradeType tradeType) {
        if(tradeType.equals(TradeType.BUY)) {
            buyCount++;
        }
    }

    public int getBuyCount() {
        return buyCount;
    }
}
