package patterns.observer;

public class DellSubscriber implements ISubscriber {
    static final String stockOfInterest = "DELL";
    int tradeCount = 0;

    @Override
    public void update(String stock, TradeType tradeType) {
        if(stock.equals(stockOfInterest)) {
            tradeCount++;
        }
    }

    public int getVolume() {
        return tradeCount;
    }
}
