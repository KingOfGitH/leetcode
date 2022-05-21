package easy;

/**
 * @author by zhangborui
 * @classname RepeatedNTimes_961
 * @description TODO
 * @date 2022/5/21 9:43
 */
public class RepeatedNTimes_961 {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return nums[0];
        }
        if (nums[1] == nums[3]) {
            return nums[1];
        }
        int index = 0;
        while (index < n - 1) {
            if (nums[index] != nums[index + 1]) {
                index++;
            } else {
                return nums[index];
            }
        }
        return nums[0];
    }
}
