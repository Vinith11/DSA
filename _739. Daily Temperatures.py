class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        res=[0]*len(temperatures)

        stack=[]

        for i,t in enumerate(temperatures):
            while stack and t>stack[-1][0]:
                stackT, StackInd=stack.pop()
                res[StackInd]=(i - StackInd)
            stack.append([t,i])

        return res
    
    
