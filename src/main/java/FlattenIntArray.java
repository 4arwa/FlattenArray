import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Arwa Arif  - arwaarif1994@gmail.com
 * Date: 18/10/2018
 * Flattens an array of arbitrarily nested arrays of integers into a flat array of integer
 */

public class FlattenIntArray {

    /**
     * Flatten an array of arbitrarily nested arrays of integers into a flat array of integers. e.g. [[1,2,[3]],4] -> [1,2,3,4].
     *
     * @param inputArray an array of Integers or nested arrays of Integers
     * @return flattened array of Integers or null if input is null
     * @throws IllegalArgumentException
     */
    public static Integer[] flatten(Object[] inputArray) throws IllegalArgumentException {

        if (inputArray == null) return null;

        List<Integer> flatList = new ArrayList<Integer>();

        for (Object element : inputArray) {
            if (element instanceof Integer) {
                flatList.add((Integer) element);
            } else if (element instanceof Object[]) {
                flatList.addAll(Arrays.asList(flatten((Object[]) element)));
            } else {
                throw new IllegalArgumentException("Input must be an array of Integers or nested arrays of Integers");
            }
        }
        return flatList.toArray(new Integer[flatList.size()]);
    }
}
