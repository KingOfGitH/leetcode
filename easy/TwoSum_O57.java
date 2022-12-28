package easy;

/**
 * @author by zhangborui
 * @classname TwoSum_O57
 * @description https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * @date 2022/12/27 16:57
 */
public class TwoSum_O57 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end) {
            int tmp = nums[begin] - target + nums[end];
            if (tmp == 0) {
                res[0] = nums[begin];
                res[1] = nums[end];
                return res;
            }
            if (tmp > 0) {
                end--;
            }else{
                begin++;
            }
        }
        return res;
    }
}
