class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int n=nums.size();
        std::sort(nums.begin(), nums.end());
        int ans;

        for(int i=1; i<n; i+=2){
            if(nums[i]!=nums[i-1]){
                return nums[i-1];
            }
        }

        return nums[nums.size()-1];
    }
};