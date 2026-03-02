package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JumpGameII_45 {
    public int jump(int[] nums) {
        if (nums.length<=1) {
            return 0;
        }
        int max = 0;
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i+nums[i]>max){
                if(i+nums[i]>=nums.length-1){
                    return tmp[i] + 1;
                }
                for (int j = max+1; j < i+nums[i]; j++) {
                    tmp[j] = tmp[i] + 1;
                }
                max = i+nums[i];
            }
        }
        return 0;
    }
}
