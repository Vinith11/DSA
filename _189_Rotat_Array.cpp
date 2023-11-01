class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        vector<int> temp(nums.size());
        for(int i=0; i<nums.size(); i++){
            temp[(i+k) % nums.size()] = nums[i];
        }
        nums = temp;
    }
};

/*
#include <bits/stdc++.h>
using namespace std;

void rotate(vector<int> &nums, int k)
{

    int n =nums.size();
    for(int j=0; j<k; j++){
        int temp=nums[n - 1];
        for (int i = n-1; i > 0; i--)
        {
            nums[i] = nums[i-1];
        }
        nums[0]= temp;
    }

    for (size_t i = 0; i < n; i++) {
        std::cout << nums[i] << " ";
    }
}

int main()
{
    std::vector<int> myVector = {1, 2, 3, 4, 5, 6, 7};
    rotate(myVector, 3);
    return 0;
}
*/