import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// As the name may already reveal, it works basically like a Fibonacci,
// but summing the last 3 (instead of 2) numbers of the sequence to generate
// the next. And, worse part of it, regrettably I won't get to hear non-native
// Italian speakers trying to pronounce it :(

public class TribonacciSequence {
    private static double[] tribonacci(double[] s, int n) {
        if (n == 0) return new double[]{};
        List<Double> arr = new ArrayList<Double>();
        if (n > 2) {
            for (double i : s) {
                arr.add(i);
            }

            for (int i = 3; i < n; i++) {
                double elemen = arr.get(i - 3) + arr.get(i - 2) + arr.get(i - 1);
                arr.add(elemen);
            }
        } else for (int i = 0; i < n; i++) {
            arr.add(s[i]);
        }

        double[] res = new double[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }

    @Test
    public static void main(String[] args) {
        Assert.assertEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, tribonacci(new double[]{1, 1, 1}, 10));
    }
}
