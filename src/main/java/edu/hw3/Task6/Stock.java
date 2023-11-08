package edu.hw3.Task6;

import java.util.Objects;

public class Stock {
    public int price;

    public Stock(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock stock = (Stock) object;
        return Integer.compare(price, stock.price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
