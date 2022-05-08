package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by zhangborui
 * @classname MinMutation_433
 * @description TODO
 * @date 2022/5/7 16:25
 */
public class MinMutation_433 {
    String target;

    public int minMutation(String start, String end, String[] bank) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(bank));
        list.remove(start);
        list.add(start);
        target = end;

        return minMutation(start, list);
    }

    public int minMutation(String cur, List<String> list) {
        if (target.equals(cur)) {
            return 0;
        }
        if (list.isEmpty() || !list.contains(cur) || !list.contains(target)) {
            return -1;
        }
        list.remove(cur);
        int res = Integer.MAX_VALUE;
        for (String s : list) {
            if (isVariable(cur, s)) {
                int a = minMutation(s, new ArrayList<>(list));
                if (a != -1) {
                    res = Math.min(res, a);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res + 1;
    }

    public boolean isVariable(String a, String b) {
        int res = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                res++;
            }
        }
        return res == 1;
    }


    public void testA(ArrayList<Integer> list) {
        list.add(1);
        testB(new ArrayList<>(list));
        System.out.println(list);
    }

    public void testB(ArrayList<Integer> list) {
        list.add(2);
        testC(list);
    }

    public void testC(ArrayList<Integer> list) {
        list.add(3);
        testD(list);
    }

    public void testD(ArrayList<Integer> list) {
        list.add(4);
    }

    public static void main(String[] args) {
        MinMutation_433 minMutation_433 = new MinMutation_433();
        System.out.println(minMutation_433.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA" }));
        System.out.println(minMutation_433.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA" }));
        System.out.println(minMutation_433.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC" }));
        System.out.println(minMutation_433.minMutation("AACCGGTT", "AACCGGTA", new String[]{}));
        System.out.println(minMutation_433.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA" }));
    }

}
