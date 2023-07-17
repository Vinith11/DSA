class Solution {
public:
    vector<int> asteroidCollision(vector<int>& arr) {

        vector<int> ans;
        int n = arr.size();

        stack<int> st;

        for(int i = 0;i<n;i++)
        {
            if(st.size()>0 && arr[i]<0 && st.top()>0)
            {
               int res  = arr[i];
               bool f = true;
               while(!st.empty() && st.top() > 0 && res<0)
               {
                   int x = st.top();
                   st.pop();
                   if(abs(res)==x)
                   {
                       f = false;
                       break;
                   }
                   if(abs(res) < x) res = x;  
                }
               if(f) st.push(res);
            }
            else
            st.push(arr[i]);
        }
        
        while(!st.empty())
        {
            ans.push_back(st.top());
            st.pop();
        }

        reverse(ans.begin(),ans.end());

        return ans;
    }
};