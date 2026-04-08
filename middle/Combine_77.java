package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by zhangborui
 * @classname Combine_77
 * @description 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * @date 2026/4/7 10:18
 */
public class Combine_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        combine(res, curList, 0, n, k);
        return res;
    }


    public void combine(List<List<Integer>> res, List<Integer> curList, int cur, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(curList));
            return;
        }
        if (cur + k > n) {
            return;
        }
        for (int i = cur; i < n; i++) {
            curList.add(i + 1);
            combine(res, curList, i + 1, n, k - 1);
            curList.remove(curList.size() - 1);
        }
    }

}
