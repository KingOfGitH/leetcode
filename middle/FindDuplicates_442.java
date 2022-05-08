package middle;

import java.util.LinkedList;
import java.util.List;

/**
 * @author by zhangborui
 * @classname FindDuplicates_442
 * @description TODO
 * @date 2022/5/8 17:08
 */
public class FindDuplicates_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -nums[index];
            if (nums[index] > 0) {
                list.add(index + 1);
            }
        }
        return list;
    }
}
