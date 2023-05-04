import controller.FibNums;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        long[] fib = FibNums.fibNums(10);
        System.out.println(Arrays.toString(fib));
    }
}
