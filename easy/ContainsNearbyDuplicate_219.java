package easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        int min = Math.min(length, k + 1);
        Set<Integer> set = new HashSet<>(min);
        for (int i = 0; i < min; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        for (int i = min; i < length; i++) {
            set.remove(nums[i - min]);
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate_219 containsNearbyDuplicate_219 = new ContainsNearbyDuplicate_219();
        System.out.println(containsNearbyDuplicate_219.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate_219.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate_219.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
