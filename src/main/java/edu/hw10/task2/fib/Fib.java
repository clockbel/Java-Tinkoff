package edu.hw10.task2.fib;

public class Fib implements FibCalculator {
    @Override
    public long fib(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1 || number == 2) {
            return 1;
        } else {
            return fib(number - 2) + fib(number - 1);
        }
    }
}
