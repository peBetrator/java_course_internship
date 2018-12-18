import org.junit.Assert;
import org.junit.Test;

// A digital root is the recursive sum of all the digits in a number.
// Given n, take the sum of the digits of n. If that value has two digits,
// continue reducing in this way until a single-digit number is produced.
// This is only applicable to the natural numbers.

public class DigitalRoot {
    private static int digital_root(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        if (res < 10) return res;//digital_root(res);
        else return digital_root(res);
    }

    @Test
    public static void main(String[] args) {
        Assert.assertEquals(7, digital_root(16));
        Assert.assertEquals(6, digital_root(456));
    }
}
