class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        String add =s+s;
        if(add.contains(goal)){
            return true;
        }
        else{
            return false;
        }
    }
}