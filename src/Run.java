import controller.FibNums;
import gui.GuiFib;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        GuiFib gui= new GuiFib();
        long[] fib = FibNums.fibNums(10);
        System.out.println(Arrays.toString(fib));
    }
}
