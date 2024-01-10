package edu.hw10.task2.fib;

import edu.hw10.task2.annotation.Cache;

public interface FibCalculator {
    @Cache(persist = true)
    long fib(int number);
}
