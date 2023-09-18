package two.pointer;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0,mid = 0, right = nums.length -1;
        while(mid <= right){
            if(nums[mid]==0){
                swap(nums,left,mid);
                left++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums,mid,right);
                right--;
            }
        }

        Arrays.stream(nums).boxed().toList().forEach(System.out::println);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr={2,0,2,1,1,0};
        new SortColors().sortColors(arr);
    }
}
