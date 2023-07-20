// nums = [1,2,3,4,3]
// stack=[]
// ans=[-1]*len(nums)

// for _ in range(2):
//     for i in range(len(nums)):
//         while stack and nums[stack[-1]]<nums[i]:
//             ans[stack.pop()]=nums[i]

//         stack.append(i)

// print(ans)

#include <bits/stdc++.h>
using namespace std;

vector<int> nextGreaterElement(vector<int> &a)
{
  int n = a.size();
  vector<int> v(n, -1);

  stack<int> st;
  for (int i = 2 * n - 1; i >= 0; i--)
  {
    // we pop out all elements smaller than current element
    while (!st.empty() && (a[i % n] >= st.top()))
    {
      st.pop();
    }

    // if stack is empty means no greater element is there
    // if not empty we make answer at that index equal to top element
    if (!st.empty() && (i < n))
    {
      v[i] = st.top();
    }

    st.push(a[i % n]);
  }

  for (auto i : v)
  {
    cout << i << " ";
  }
}

int main()
{

  vector<int> v;
  v.push_back(1);
  v.push_back(2);
  v.push_back(1);
  nextGreaterElement(v);
  return 0;
}