class Solution:
    def calPoints(self, operations: List[str]) -> int:
        rec = []
        res = 0
        for num in operations:
            if num == 'C':
                n = len(rec)
                rec.pop()


            elif num == 'D':
              n = len(rec)
              rec.append(2*rec[n-1])

            elif num == '+':
              n = len(rec)
              rec.append(rec[n-1]+rec[n-2])
            else:
                val = int(num)
                rec.append(val)
        for num in rec:
            res = res+num
        return res

