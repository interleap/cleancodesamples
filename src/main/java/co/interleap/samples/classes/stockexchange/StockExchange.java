package co.interleap.samples.classes.stockexchange;

public interface StockExchange {
  Money currentPrice(String symbol);
}
