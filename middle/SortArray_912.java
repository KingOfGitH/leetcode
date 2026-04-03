package middle;

import java.util.Arrays;

/**
 * @author by zhangborui
 * @classname SortArray_912
 * @description TODO
 * @date 2026/4/2 13:52
 */
public class SortArray_912 {

    public static void main(String[] args) {
        SortArray_912 sortArray912 = new SortArray_912();
        System.out.println(Arrays.toString(sortArray912.sortArray(new int[]{110, 100, 0})));
        System.out.println(Arrays.toString(sortArray912.sortArray(new int[]{5,1,1,2,0,0})));

    }
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 1 1 1 2 0 5
    private int partition2(int[] a, int left, int right) {
        int cur = left;
        while (left < right){
            while (left < right && a[left] <= a[right])
            {
                right--;
            }
            while (left < right && a[left] <= a[right])
            {
                left++;
            }
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }
        int temp = a[left];
        a[left] = a[cur];
        a[cur] = temp;
        return left;
    }

    private int partition1(int[] nums, int low, int high) {
        int slow=low,fast=low;
        while (fast < high){
            if (nums[fast]>nums[high]){
                fast++;
            }else {
                int temp=nums[fast];
                nums[fast++]=nums[slow];
                nums[slow++]=temp;
            }
        }
        int temp=nums[fast];
        nums[fast]=nums[slow];
        nums[slow]=temp;
        return slow;
    }

    private int partition(int[] nums, int low, int high) {
        int cur = nums[(low+high)/2];
        nums[(low+high)/2] = nums[low];
        nums[low] = cur;
        while (low < high) {
            while (low < high && nums[high] >= cur) {
                high--;
            }
            if (low < high) {
                nums[low++] = nums[high];
            }
            while (low < high && nums[low] < cur) {
                low++;
            }
            if (low < high) {
                nums[high--] = nums[low];
            }
        }
        nums[low] = cur;
        return low;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = partition(nums, low, high);
        quickSort(nums, low, index - 1);
        quickSort(nums, index + 1, high);
    }
}
