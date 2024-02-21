package test.david.service;

import java.math.BigInteger;

public interface FibonacciService {

    /**
     * Calculate fibonacci number for pos 'n'
     *
     * @param n position in fibonacci sequence
     * @return fibonacci number
     */
    BigInteger calculateFibonacci(final Integer n);

}
