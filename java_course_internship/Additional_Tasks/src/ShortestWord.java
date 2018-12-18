import org.junit.Assert;
import org.junit.Test;

// Simple, given a string of words, return the length of the shortest word(s).
// String will never be empty and you do not need to account for different data types.

public class ShortestWord {
    public static int findShort(String s) {
        String str = s + " ";
        char ch = ' ';
        int len = str.length(), l = 0;
        int min = len, max = 0;
        String shortest_word = "", longest_word = "", word = "";
        for (int i = 0; i < len; i++) {
            ch = str.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else {
                l = word.length();
                if (l < min) {
                    min = l;
                    shortest_word = word;
                }
                if (l > max) {
                    max = l;
                    longest_word = word;
                }
                word = "";
            }
        }
        return min;
    }

    @Test
    public static void main(String[] args) {
        Assert.assertEquals(3, findShort("bitcoin take over the world maybe who knows perhaps"));
        Assert.assertEquals(3, findShort("turns out random test cases are easier than writing out basic ones"));
    }
}
