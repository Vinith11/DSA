class Solution {
public:
    bool check(vector<int>& a) {
        int count=0;

        int n=a.size();


        for(int i=1; i<n; i++){
            if(a[i]<a[i-1]){
                count++;
            }
        }

        if(a[n-1] >  a[0]){
            count++;
        }

        return count<=1;
    }
};