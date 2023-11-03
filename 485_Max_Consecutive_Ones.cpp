class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
	    int count = 0;
        int ans = -1;

        int n = nums.size();

        for (int i=0; i<n; i++){
            if(nums[i]==0){
                count=0;
            }
            else if(nums[i]==1){
                count++;
            }
            ans=max(ans,count);
        }

        return ans;        
    }
};