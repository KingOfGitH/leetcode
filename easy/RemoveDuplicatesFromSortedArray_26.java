package easy;

public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        int res = nums.length == 0 ? 0 : 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            nums[res++]=nums[i];
        }
        return res;
    }
}
