import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class OperationsWithLists {
    @Test
    public void verifyConcat() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Max");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Kek");
        GenericClass<String> result = new GenericClass<>();
        ArrayList<String> a = new ArrayList<>();
        a.add("Max");
        a.add("Kek");
        Assert.assertEquals(a, result.concatList(list1, list2));
    }

    @Test
    public void verifyDiffer() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Max");
        list1.add("Lol");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Lol");
        GenericClass<String> result = new GenericClass<>();
        ArrayList<String> a = new ArrayList<>();
        a.add("Max");
        Assert.assertEquals(a, result.findUnCommon(list1, list2));
    }

    @Test
    public void verifyCommon() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Max");
        list1.add("Lol");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Lol");
        GenericClass<String> result = new GenericClass<>();
        ArrayList<String> a = new ArrayList<>();
        a.add("Lol");
        Assert.assertEquals(a, result.findCommon(list1, list2));
    }
}
