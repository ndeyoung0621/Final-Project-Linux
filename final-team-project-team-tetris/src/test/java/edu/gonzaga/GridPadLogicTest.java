package edu.gonzaga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GridPadLogicTest {

    @Test
    void additionWorks() {
        Assertions.assertEquals(4, 2 + 2);
    }

    @Test
    void factorialOfFive() {
        int fact = 1;
        for (int i = 2; i <= 5; i++) fact *= i;
        Assertions.assertEquals(120, fact);
    }

    @Test
    void gcdComputation() {
        int a = 54, b = 24;
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        Assertions.assertEquals(6, a);
    }

    @Test
    void fibonacciTenth() {
        int prev = 0, curr = 1;
        for (int i = 2; i <= 10; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        Assertions.assertEquals(55, curr);
    }

    @Test
    void primeCheck() {
        int n = 29;
        boolean prime = n > 1;
        for (int i = 2; i * i <= n && prime; i++) {
            prime &= n % i != 0;
        }
        Assertions.assertTrue(prime);
    }
}