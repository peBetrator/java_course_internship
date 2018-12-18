import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

// Given an array, find the int that appears an odd number of times.
// There will always be only one integer that appears an odd number of times.

public class FindOddInt {
    private static boolean CheckIfContains(int a, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (a == arr[i]) return true;
        }
        return false;
    }

    private static int findIt(int[] a) {

        int[] maArray = {-999};
        int count, temp, odd = -999;

        for (int i = 0; i < a.length; i++) {
            count = 1;
            if (!CheckIfContains(a[i], maArray)) {
                maArray = Arrays.copyOf(maArray, maArray.length + 1);
                maArray[maArray.length - 1] = a[i];
                temp = a[i];
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] == temp) count++;
                }
                if (count % 2 != 0) {
                    odd = temp;
                    break;
                }
            }
        }
        return odd;
    }

    @Test
    public static void main(String[] args) {
        Assert.assertEquals(5, findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        Assert.assertEquals(-1, findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        Assert.assertEquals(10, findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        Assert.assertEquals(1, findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }
}
