package patterns.observer;

public class SellSubscriber implements ISubscriber {
    int sellCount;

    @Override
    public void update(String stock, TradeType tradeType) {
        if(tradeType.equals(TradeType.SELL)) {
            sellCount++;
        }
    }

    public int getSellCount() {
        return sellCount;
    }
}
