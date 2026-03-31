package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by zhangborui
 * @classname IsSubsequence_392
 * @description 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * @date 2026/3/31 15:39
 */
public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        Map<Integer, List<Integer>> map = new HashMap<>(26);
        for (int i = 0; i < t.length(); i++) {
            List<Integer> list = map.getOrDefault(t.charAt(i) - 'a', new ArrayList<>());
            list.add(i);
            map.put(t.charAt(i) - 'a', list);
        }
        int[] cur = new int[26];
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            List<Integer> integers = map.get(j);
            if (integers == null || integers.size() <= cur[j] ) {
                return false;
            }
            while (integers.get(cur[j]) <= index) {
                cur[j]++;
                if (integers.size() <= cur[j]){
                    return false;
                }
            }
            index = integers.get(cur[j]);
        }
        return true;
    }
}
