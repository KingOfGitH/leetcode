package middle;

/**
 * @author by zhangborui
 * @classname MinSubArrayLen_209
 * @description 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * @date 2026/4/1 16:27
 */
public class MinSubArrayLen_209 {

    // 2 3 1 2 4 3    7
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int index = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                while (index <= i && sum >= target) {
                    res = Math.min(res, i - index + 1);
                    if (res == 1) {
                        return 1;
                    }
                    sum -= nums[index++];
                }
            }

        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }



}
