package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StockExchange implements StockMarket {

    private final PriorityQueue<Stock> stocks;

    public StockExchange() {
        stocks = new PriorityQueue<>(new Comparator<Stock>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                return -Integer.compare(o1.getPrice(), o2.getPrice());
            }
        });
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
