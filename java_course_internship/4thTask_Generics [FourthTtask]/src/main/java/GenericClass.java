import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

//TODO
//Continue with generic utility-class for ArrayList (we have started it on lesson), define methods:
//- for defining difference between two lists
//- for defining the intersection between two lists
//- for defining if two lists are elements in common (see Collections.disjoint())

public class GenericClass<T> {
    protected ArrayList<T> concatList(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<T> result = new ArrayList<>();

        result.addAll((Collection<? extends T>) list1);
        result.addAll((Collection<? extends T>) list2);

        return result;
    }

    protected ArrayList<T> findUnCommon(ArrayList<String> a, ArrayList<String> b) {
        ArrayList<T> result = a.stream().filter(el -> !b.contains(el)).map(el -> (T) el).collect(Collectors.toCollection(ArrayList::new));
        b.stream().filter(el -> !a.contains(el)).map(el -> (T) el).forEach(result::add);
//        for (T el : a) {
//            if (!b.contains(el)) {
//                result.add((T) el);
//            }
//        }
//        for (T el : b) {
//            if (!a.contains(el)) {
//                result.add((T) el);
//            }
//        }
        return result;
    }

    protected ArrayList<T> findCommon(ArrayList<String> a, ArrayList<String> b) {
        ArrayList<T> result = a.stream().filter(b::contains).filter(a::contains).map(el -> (T) el).collect(Collectors.toCollection(ArrayList::new));
//        for (T el : a) {
//            if (b.contains(el)) if (a.contains(el)) result.add((T) el);
//        }
        return result;
    }
}
