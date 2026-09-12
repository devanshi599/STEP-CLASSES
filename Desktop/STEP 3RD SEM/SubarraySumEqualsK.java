import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefixSumFrequency =
                new HashMap<>();

        // Empty prefix
        prefixSumFrequency.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum += num;

            // Look for an earlier prefix sum
            // equal to currentSum - k
            int requiredSum = currentSum - k;

            if (prefixSumFrequency.containsKey(requiredSum)) {
                count += prefixSumFrequency.get(requiredSum);
            }

            // Store current prefix sum
            prefixSumFrequency.put(
                currentSum,
                prefixSumFrequency.getOrDefault(
                    currentSum,
                    0
                ) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println(subarraySum(nums, k));
    }
}