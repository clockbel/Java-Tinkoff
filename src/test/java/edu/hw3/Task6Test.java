package edu.hw3;

import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockPackage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Test1")
    public void Test1() {
        Stock firstStock = new Stock(1000);
        Stock secondStock = new Stock(2000);
        Stock thridStock = new Stock(3000);
        StockPackage stockPackage = new StockPackage();
        stockPackage.add(firstStock);
        stockPackage.add(secondStock);
        stockPackage.add(thridStock);
        assertThat(stockPackage.mostValuableStock()).isEqualTo(thridStock);
    }
}
