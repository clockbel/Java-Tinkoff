package edu.hw3.Task6;

import java.util.PriorityQueue;

public class StockPackage implements StockMarket {

    private final PriorityQueue<Stock> stocks;

    public StockPackage() {
        stocks = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1.getPrice(), o2.getPrice()));
    }

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
