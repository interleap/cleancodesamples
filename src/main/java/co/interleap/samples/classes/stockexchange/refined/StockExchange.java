package co.interleap.samples.classes.stockexchange.refined;

public interface StockExchange {
  Money currentPrice(String symbol);
}
