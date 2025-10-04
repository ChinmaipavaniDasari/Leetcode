class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1,currarea=0,maxarea=0;
    while(left<right){
        currarea = (Math.min(height[left],height[right]))*(right-left);
        maxarea = Math.max(maxarea,currarea);
        if(height[left]<height[right]) left++;
        else right--;
    }
    return maxarea;

    }
}