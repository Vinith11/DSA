class Solution(object):
    def moveZeroes(self, nums):
        c=0
        for i in nums:
            if i == 0:
                
                nums.remove(0)
                nums.append(0)
            
        
      
            
