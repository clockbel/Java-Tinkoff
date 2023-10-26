package edu.hw3.Task6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Objects;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        Stock firstStock = new Stock(100);
        Stock secondStock = new Stock(200);
        Stock thirdStock = new Stock(300);
        StockExchange stockExchange = new StockExchange();
        stockExchange.add(firstStock);
        stockExchange.add(secondStock);
        stockExchange.add(thirdStock);
        LOGGER.info(Objects.equals(stockExchange.mostValuableStock(), thirdStock));
    }
}
