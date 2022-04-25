package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author by zhangborui
 * @classname Solution_398
 * @description TODO
 * @date 2022/4/25 22:55
 */
public class Solution_398 {
    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> map2 = new HashMap<>();
    Random random = new Random();

    public Solution_398(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (!map2.containsKey(nums[i])) {
                    map2.put(nums[i], new ArrayList<>());
                    map2.get(nums[i]).add(map.get(nums[i]));
                }
                map2.get(nums[i]).add(i);
            }
            map.put(nums[i], i);
        }
    }

    public int pick(int target) {
        if (map2.containsKey(target)) {
            return map2.get(target).get(random.nextInt(map2.get(target).size()));
        } else {
            return map.get(target);
        }
    }

    public static void main(String[] args) {
        Solution_398 solution_398 = new Solution_398(new int[]{1, 2, 3, 3, 3});
        System.out.println(solution_398.map);
        System.out.println(solution_398.map2);
    }
}
