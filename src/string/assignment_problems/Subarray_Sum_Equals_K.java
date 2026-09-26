package string.assignment_problems;

import java.util.HashMap;

public class Subarray_Sum_Equals_K {

    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum += num;

            int requiredSum = currentSum - k;

            if (prefixSumCount.containsKey(requiredSum)) {
                count += prefixSumCount.get(requiredSum);
            }

            prefixSumCount.put(
                    currentSum,
                    prefixSumCount.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println(result);
    }
}