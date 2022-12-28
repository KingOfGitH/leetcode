package easy;

/**
 * @author by zhangborui
 * @classname FirstUniqChar_50
 * @description https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @date 2022/12/28 15:06
 */
public class FirstUniqChar_50 {
    public char firstUniqChar(String s) {
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            if (index[j] != -1) {
                if (index[j] == 0) {
                    index[j] = i + 1;
                } else {
                    index[j] = -1;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : index) {
            if (i > 0) {
                res = Math.min(res, i);
            }
        }
        return res == Integer.MAX_VALUE ? ' ' : s.charAt(res - 1);
    }
}
