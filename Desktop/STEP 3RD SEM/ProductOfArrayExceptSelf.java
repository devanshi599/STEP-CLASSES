import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: store product of elements to the left
        answer[0] = 1;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Backward pass: multiply by product of elements to the right
        int rightProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] answer = productExceptSelf(nums);

        System.out.println(Arrays.toString(answer));
    }
}