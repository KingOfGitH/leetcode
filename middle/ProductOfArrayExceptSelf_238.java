package middle;

public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] before = new int[nums.length];
        int[] after = new int[nums.length];
        before[0] = nums[0];
        after[nums.length-1] = nums[nums.length-1];
        for(int i=1; i<nums.length; i++){
            before[i]=before[i-1]*nums[i];
            int afIndex = nums.length - 1 - i;
            after[afIndex]=after[afIndex+1]*nums[afIndex];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (i == 0) {
                res[i] = after[i+1];
                continue;
            }
            if (i == nums.length - 1) {
               res[i] = before[i-1];
               continue;
            }
            res[i] = before[i-1]*after[i+1];
        }
        return res;
    }
}
