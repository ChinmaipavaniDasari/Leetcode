class Solution:
    def largestGoodInteger(self, num: str) -> str:
        n = len(num)
        ans=""
        for i in range(n-2):
            if(num[i]== num[i+1] == num[i+2]):
                val = num[i:i+3]
                if(val>ans):
                    ans = val
        return ans
