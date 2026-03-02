package middle;

public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int cur = nums.length-1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i]+i<cur) {
                while (--i >= 0){
                    if (nums[i]+i>=cur) break;
                }
            }
            cur = i;
        }
        return cur==0;
    }
}
