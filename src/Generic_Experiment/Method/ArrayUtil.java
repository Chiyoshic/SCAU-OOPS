package Generic_Experiment.Method;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

    public static <T> T[] removeDuplicates(T[] array) {
        if (array == null) return null;
        List<T> list = new ArrayList<>();
        for (T item : array) {
            if (item != null && !list.contains(item)) {
                list.add(item);
            }
        }
        T[] result = (T[]) java.lang.reflect.Array.newInstance(
                array.getClass().getComponentType(), list.size());
        return list.toArray(result);
    }

    public static <T extends Comparable<T>> T max(T[] array) {
        if (array == null || array.length == 0) return null;
        T max = array[0];
        for (T item : array) {
            if (item != null && (max == null || item.compareTo(max) > 0)) {
                max = item;
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> T min(T[] array) {
        if (array == null || array.length == 0) return null;
        T min = array[0];
        for (T item : array) {
            if (item != null && (min == null || item.compareTo(min) < 0)) {
                min = item;
            }
        }
        return min;
    }
}