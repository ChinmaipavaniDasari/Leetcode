class Solution {
    public int findClosest(int x, int y, int z) {
        int first = Math.abs(z-x);
        int second = Math.abs(z-y);
        if(first == second){
            return 0;
        }
        if(first<second) return 1;
        else return 2;
    }
}