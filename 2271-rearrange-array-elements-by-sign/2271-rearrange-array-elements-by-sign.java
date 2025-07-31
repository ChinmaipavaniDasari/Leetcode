class Solution {
    public int[] rearrangeArray(int[] nums) {
        int evenIndex = 1;
        int oddIndex = 0;
        int[] arr = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            if(nums[i]>0){
                arr[oddIndex] = nums[i];
                oddIndex += 2;
            }
            else if(nums[i]<0){
                arr[evenIndex] = nums[i];
                evenIndex += 2;
            }
        }
        return arr;
    }
}