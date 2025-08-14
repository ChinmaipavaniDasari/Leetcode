class Solution {
    public int compress(char[] chars) {
        int readindex = 0;
        int writeindex = 0;
        while(readindex < chars.length){
            char currentChar = chars[readindex];
            int count = 0;
            while(readindex < chars.length && chars[readindex] == currentChar){
                readindex++;
                count++;
            }
            chars[writeindex] = currentChar;
            writeindex++;
        
            if(count >1){
                String countStr = String.valueOf(count);
                for(char c : countStr.toCharArray()){
                    chars[writeindex] = c;
                    writeindex++;
                }
            }
        }
        return writeindex;
    }
}