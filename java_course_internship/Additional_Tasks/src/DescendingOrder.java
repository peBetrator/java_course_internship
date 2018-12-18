import org.junit.Assert;
import org.junit.Test;

// Your task is to make a function that can take any non-negative integer as a argument
// and return it with its digits in descending order. Essentially, rearrange the digits
// to create the highest possible number.

public class DescendingOrder {
    private static int sortDesc(final int numb) {
        int num = numb;
        int[] times = new int[10];
        if (num < 10) return numb;
        while (num != 0) {
            int value = num % 10;
            times[value]++;
            num /= 10;
        }
        String largestNumber = "";
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < times[i]; j++) {
                largestNumber += i;
            }
        }
        return Integer.parseInt(largestNumber);
    }

    @Test
    public static void main(String[] args) {
        Assert.assertEquals(0, DescendingOrder.sortDesc(0));
        Assert.assertEquals(987654321, DescendingOrder.sortDesc(123456789));
        Assert.assertEquals(51, DescendingOrder.sortDesc(15));
    }
}
