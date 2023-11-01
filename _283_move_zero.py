class Solution(object):
    def moveZeroes(self, nums):
        c=0
        for i in nums:
            if i == 0:
                
                nums.remove(0)
                nums.append(0)

'''
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int h=0;
        for(int i=0; i<nums.size(); i++){
            if (nums[i] != 0) {
                swap(nums[i], nums[h]);
                h++;
            }
        }
    }
};
'''
        
      
            
