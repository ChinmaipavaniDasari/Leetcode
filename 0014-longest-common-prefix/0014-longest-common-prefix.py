class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        strs.sort()
        prefix = []
        first,second = strs[0],strs[-1]
        for i in range(min(len(first),len(second))):
            if first[i] == second[i]:
                prefix.append(first[i])
            else:
                break
        return "".join(prefix)