package unit.test.david.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import test.david.FibonacciApplication;
import test.david.service.FibonacciService;

import java.math.BigInteger;

@SpringBootTest(classes = FibonacciApplication.class)
@AutoConfigureMockMvc
public class FibonacciServiceTest {

    @Autowired
    private FibonacciService service;

    @Test
    public void testSuccess1() {
        final BigInteger result = service.calculateFibonacci(1);

        Assertions.assertEquals(BigInteger.ONE, result);
    }

    @Test
    public void testSuccess10() {
        final BigInteger result = service.calculateFibonacci(10);

        Assertions.assertEquals(new BigInteger("55"), result);
    }

    @Test
    public void testSuccess72() {
        final BigInteger result = service.calculateFibonacci(72);

        Assertions.assertEquals(new BigInteger("498454011879264"), result);
    }

    @Test
    public void testError0() {
        Executable e = () -> service.calculateFibonacci(0);
        Assertions.assertThrowsExactly(IllegalArgumentException.class, e);
    }

    @Test
    public void testErrorNegativeNumber() {
        Executable e = () -> service.calculateFibonacci(-1);
        Assertions.assertThrowsExactly(IllegalArgumentException.class, e);
    }
}
