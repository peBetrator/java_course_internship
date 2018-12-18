import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Given a list lst and a number N, create a new list that contains each number
// of lst at most N times without reordering. For example if N = 2, and the input
// is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2] since this would
// lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].

public class EnoughIsEnough {
    private static int[] deleteNth(int[] elements, int maxOccurrences) {
        List<Integer> dynamic_arr = new ArrayList<Integer>();
        List<Integer> temp_arr = new ArrayList<Integer>();
        int count;
        for (int i : elements) {
            dynamic_arr.add(i);
        }

        if (maxOccurrences == 1) dynamic_arr = dynamic_arr.stream().distinct().collect(Collectors.toList());

        for (int i = 0; i < dynamic_arr.size(); i++) {
            if (!temp_arr.contains(dynamic_arr.get(i))) {
                count = 0;
                for (int j = i; j < dynamic_arr.size(); j++) {
                    if (dynamic_arr.get(i) == dynamic_arr.get(j)) {
                        if (count == maxOccurrences) dynamic_arr.remove(j);
                        else count++;
                    }
                }
            }
        }
        if (maxOccurrences == 0) return new int[]{};
        int[] res = new int[dynamic_arr.size()];
        for (int i = 0; i < dynamic_arr.size(); i++) {
            res[i] = dynamic_arr.get(i);
        }
        return res;
    }

    @Test
    public static void main(String[] args) {
        Assert.assertEquals(
                new int[]{20, 37, 21},
                EnoughIsEnough.deleteNth(new int[]{20, 37, 20, 21}, 1)
        );
        Assert.assertEquals(
                new int[] { 1, 1, 3, 3, 7, 2, 2, 2 },
                EnoughIsEnough.deleteNth( new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3 )
        );
        Assert.assertEquals(
                new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 },
                EnoughIsEnough.deleteNth( new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3 )
        );
        Assert.assertEquals(
                new int[] { 1, 1, 1, 1, 1 },
                EnoughIsEnough.deleteNth( new int[] { 1, 1, 1, 1, 1 }, 5 )
        );
    }
}
