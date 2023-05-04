package controller;

import java.math.BigInteger;

public class FibNums {
    public static BigInteger[] fibNums(int num) {
        BigInteger[] array = new BigInteger[num + 1];
        array[0] = BigInteger.valueOf(0);
        array[1] = BigInteger.valueOf(1);

        for (int i = 2; i <= num; i++) {
            array[i]=array[i-1].add(array[i-2]);
        }
        return array;

    }
}
