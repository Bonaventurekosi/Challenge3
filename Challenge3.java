import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge3 {

    // Method to find a subset of the array elements that adds up to the target sum
    public static List<Integer> subsetSum(int[] nums, int target) {
        // Check if the input array is null or empty
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        int n = nums.length;
        // Create a 2D list to store the subsets that add up to each target sum
        List<Integer>[] dp = new ArrayList[target + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(-1); // Base case: empty subset sums up to 0

        // Iterate through the array elements and target sums to fill up the DP array
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                if (dp[j - num] != null && dp[j] == null) {
                    List<Integer> newSubset = new ArrayList<>(dp[j - num]);
                    newSubset.add(num);
                    dp[j] = newSubset;
                }
            }
        }

        // Return the subset that adds up to the target sum
        return dp[target];
    }

    // Main method to test the subsetSum function
    public static void main(String[] args) {
        try {
            int[] nums = { 1, 3, 5, 0, 11, 17, 9, 5 };
            int target = 10;
            System.out.println("Target Sum: " + target);
            List<Integer> subset = subsetSum(nums, target);
            if (subset == null) {
                System.out.println("No subset found.");
            } else {
                // Filter out the dummy value -1 from the subset
                subset.removeIf(num -> num == -1);
                System.out.println("Subset Exists: " + subset);
            }
        } catch (IllegalArgumentException e) {
            // Catch and handle any IllegalArgumentException thrown by the subsetSum
            // function
            System.err.println("Error: " + e.getMessage());
        }
    }
}