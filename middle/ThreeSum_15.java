package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int[] tmp = new int[]{i, nums.length};
            while ((tmp = twoSum(nums, -nums[i], tmp[0] + 1, tmp[1] - 1)) != null) {
                res.add(Arrays.asList(nums[i], nums[tmp[0]], nums[tmp[1]]));
                while (tmp[0] < tmp[1] && nums[tmp[0] + 1] == nums[tmp[0]]) {
                    tmp[0]++;
                }
            }
        }
        return res;
    }

    public int[] twoSum(int[] numbers, int target, int left, int right) {
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left, right};
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            }
        }
        return null;
    }

}
