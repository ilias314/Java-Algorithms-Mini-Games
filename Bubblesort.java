import java.util.Arrays;
import java.util.Random;

public class Bubblesort {

    static void swap(int[] nums, int i, int j) {
        assert i >= 0 && i < nums.length;
        assert j >= 0 && j < nums.length;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static boolean bubble(int[] numbers) {
        boolean swapped = false;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                swap(numbers, i, i + 1);
                swapped = true;
            }
        }
        return swapped;
    }

    static int[] bubblesort(int... numbers) {
        while (bubble(numbers));
        return numbers;
    }

    static boolean bubblesortTest(int[] numbers) {
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);  
        Arrays.sort(numbersCopy);
        return Arrays.equals(numbersCopy, numbers);
    }

    public static void main(String[] args) {
        AssertionError ae = null;
        try { assert false; }
        catch (AssertionError exception) { ae = exception; }
        if (ae == null) System.out.println("WARNING: Turn assertions on with \"java -ea BubbleSortTest\"");

        assert Arrays.equals(new int[]{}, bubblesort());
        assert Arrays.equals(new int[]{}, bubblesort(new int[]{}));
        assert Arrays.equals(new int[]{3}, bubblesort(new int[]{3}));
        assert Arrays.equals(new int[]{3, 5}, bubblesort(new int[]{3, 5}));
        assert Arrays.equals(new int[]{3, 5}, bubblesort(new int[]{5, 3}));
        assert Arrays.equals(new int[]{3, 3}, bubblesort(new int[]{3, 3}));
        assert Arrays.equals(new int[]{1, 2, 3}, bubblesort(new int[]{1, 2, 3}));
        assert Arrays.equals(new int[]{1, 2, 3}, bubblesort(new int[]{1, 3, 2}));
        assert Arrays.equals(new int[]{1, 2, 3}, bubblesort(new int[]{2, 1, 3}));
        assert Arrays.equals(new int[]{1, 2, 3}, bubblesort(new int[]{2, 3, 1}));
        assert Arrays.equals(new int[]{1, 2, 3}, bubblesort(new int[]{3, 1, 2}));
        assert Arrays.equals(new int[]{1, 2, 3}, bubblesort(new int[]{3, 2, 1}));

        
        assert bubblesortTest(new int[]{4, 3, 7, 1, 5, 2});
        assert bubblesortTest(new Random().ints(20, 0, 100).toArray());

        System.out.println("All tests passed!");
    }
}
