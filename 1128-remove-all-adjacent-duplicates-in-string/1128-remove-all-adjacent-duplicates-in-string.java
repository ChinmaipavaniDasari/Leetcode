class Solution {
    public String removeDuplicates(String s) {
        char sta[] = new char[s.length()];
        int top = -1;
        for(char ch : s.toCharArray()){
            if(top>=0 && sta[top] == ch){
                top--;
            }
            else{
                sta[++top] = ch;
            }
        }
        return new String(sta,0,top+1);
    }
}