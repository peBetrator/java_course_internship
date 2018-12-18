import org.junit.Assert;
import org.junit.Test;

// Complete the method/function so that it converts dash/underscore delimited words into camel casing.
// The first word within the output should be capitalized only if the original word was capitalized.

public class toCamelCase {
    static String toCamelCase(String s) {
        String[] parts = s.split("[^a-zA-Z]");
        String res = "";

        for (int i = 0; i < parts.length; i++) {
            if (i == 0) res += parts[i];
            else res += parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1).toLowerCase();

        }
        return res;
    }

    @Test
    public static void main(String[] args) {
        String input = "the_Stealth_Warrior";
        Assert.assertEquals("theStealthWarrior", toCamelCase(input));
        input = "the-Stealth-Warrior";
        Assert.assertEquals("theStealthWarrior", toCamelCase(input));
    }
}
