class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """

        res=[]

        def backtrack(start, comb):
            if len(comb)==k:
                res.append(comb.copy())
                return 
            
            for i in range(start,n+1):
                comb.append(i)
                backtrack(i+1,comb)
                comb.pop()        
        backtrack(1,[])
        return res
