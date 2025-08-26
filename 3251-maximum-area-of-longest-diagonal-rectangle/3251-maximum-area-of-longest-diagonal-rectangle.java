class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int area = 0;
        int max = 0;
        int currarea = 0;
        int n = dimensions.length;
        for(int i =0;i<n;i++){
            int sol = (dimensions[i][0]*dimensions[i][0])+(dimensions[i][1]*dimensions[i][1]);
            currarea = dimensions[i][0]*dimensions[i][1];
            if(sol>max){
                max = sol;
                area = currarea;
            }
            else if(sol == max && currarea>area){
                area = currarea;
            }
        }
        return area;
    }
}