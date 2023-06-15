class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        def backtrack(start,subset):
            if len(subset)==len(s):
                res.append(subset[:])
                return

            for i in range(start,len(s)):
                if s[i].isdigit():
                    backtrack(i+1,subset+s[i])
                else:
                    backtrack(i+1,subset+s[i].lower())
                    backtrack(i+1,subset+s[i].upper())


        res=[]
        backtrack(0,"")

        return res