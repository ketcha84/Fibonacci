package controller;

public class FibNums {
    public static long[] fibNums(int num) {
        long[] arr = new long[num + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= num; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }
}
