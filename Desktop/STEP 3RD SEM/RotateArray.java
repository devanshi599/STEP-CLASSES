import java.util.Arrays;

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {

        int n = nums.length;

        // Reduce k if it is greater than array length
        k = k % n;

        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {

            int newIndex = (i + k) % n;

            newArray[newIndex] = nums[i];
        }

        // Copy rotated values back into original array
        for (int i = 0; i < n; i++) {
            nums[i] = newArray[i];
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {
            1, 2, 3, 4, 5, 6, 7
        };

        int k = 3;

        int[] result = rotateArray(nums, k);

        System.out.println(Arrays.toString(result));
    }
}