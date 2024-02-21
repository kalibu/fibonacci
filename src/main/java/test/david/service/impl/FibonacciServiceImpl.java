package test.david.service.impl;

import org.springframework.stereotype.Service;
import test.david.service.FibonacciService;

import java.math.BigInteger;

@Service
public class FibonacciServiceImpl implements FibonacciService {

    public BigInteger calculateFibonacci(final Integer n){

        if(n == null || n < 1){
            throw new IllegalArgumentException("The number cannot be null and need to be greater than zero.");
        }

        if(n < 3){
            return BigInteger.ONE;
        }

        BigInteger behind = BigInteger.ONE;
        BigInteger actual = BigInteger.ONE;

        for (int i = 3; i<=n; i++){
            BigInteger newValue = behind.add(actual);
            behind = actual;
            actual = newValue;
        }

        return actual;
    }

}
