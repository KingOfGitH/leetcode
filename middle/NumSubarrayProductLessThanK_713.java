package middle;

/**
 * @author by zhangborui
 * @classname NumSubarrayProductLessThanK_713
 * @description TODO
 * @date 2022/5/6 14:49
 */
public class NumSubarrayProductLessThanK_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int begin = 0, end = 0, cur = 1, res = 0;
        while (end < nums.length) {
            cur *= nums[end];
            if (cur >= k) {
                while (begin <= end && cur >= k) {
                    cur /= nums[begin];
                    begin++;
                }
            }
            res += end - begin + 1;
            end++;
        }
        return res;
    }
}
