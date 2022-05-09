package easy;

/**
 * @author by zhangborui
 * @classname DiStringMatch_942
 * @description TODO
 * @date 2022/5/9 16:27
 */
public class DiStringMatch_942 {
    public int[] diStringMatch(String s) {
        int length = s.length();
        int[] res = new int[length + 1];
        int min = 0, max = length;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'I') {
                res[i] = min++;
            } else {
                res[i] = max--;
            }
        }
        res[length] = max;
        return res;
    }
}
