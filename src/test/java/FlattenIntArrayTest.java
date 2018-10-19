import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Arwa Arif  - arwaarif1994@gmail.com
 * Date: 18/10/2018
 * Tests FlattenIntArray
 */
public class FlattenIntArrayTest {

    Integer[] expectedArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void testNullReturnsNull() throws IllegalArgumentException {
        Assert.assertNull(
                "Testing a null argument",
                FlattenIntArray.flatten(null)
        );
    }

    @Test
    public void testEmptyArray() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing an empty array",
                new Integer[]{},
                FlattenIntArray.flatten(new Object[]{})
        );
    }

    @Test
    public void testFlatArray() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing a flat array",
                expectedArray,
                FlattenIntArray.flatten(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
        );
    }

    @Test
    public void testNestedArray() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing nested array",
                expectedArray,
                FlattenIntArray.flatten(new Object[]{1, 2, 3, 4, new Object[]{5, 6, 7, 8}, 9, 10})
        );
    }

    @Test
    public void testMultipleNestedArrays() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing multiple nested arrays",
                expectedArray,
                FlattenIntArray.flatten(new Object[]{1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10})
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForObjectInArray() throws IllegalArgumentException {
        FlattenIntArray.flatten(
                new Object[]{new Object()}
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForObjectInNestedArray() throws IllegalArgumentException {
        FlattenIntArray.flatten(
                new Object[]{1, 2, new Object[]{3, new Object()}}
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForNullInArray() throws IllegalArgumentException {
        FlattenIntArray.flatten(
                new Object[]{null}
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForNullInNestedArray() throws IllegalArgumentException {
        FlattenIntArray
                .flatten(
                new Object[]{1, 2, new Object[]{3, null}}
        );
    }

}
