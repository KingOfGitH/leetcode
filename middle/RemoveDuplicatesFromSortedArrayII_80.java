package middle;

public class RemoveDuplicatesFromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        int res = nums.length == 0 ? 0 : 1;
        int flag = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                if(flag < 2 ){
                    nums[res++] = nums[i];
                    flag++;
                }
                continue;
            }
            flag = 1;
            nums[res++] = nums[i];
        }
        return res;
    }
}
