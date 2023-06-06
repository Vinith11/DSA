class Solution(object):
    def rotate(self, nums, k):
        if(k==0 or len(nums)==1 or len(nums)==k):
            return nums
        k=k%len(nums)
        nums[:] = nums[-k:]+nums[:-k]
        
        
    