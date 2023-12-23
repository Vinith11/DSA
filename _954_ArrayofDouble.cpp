#include <bits/stdc++.h>
#include <iostream>
#include <vector>
using namespace std;

static bool cmp(int &a, int &b)
{
    return abs(a) < abs(b);
}

int main()
{
    vector<int> arr = {-3, 1, 4, 6};
    int n = arr.size();
    cout << "Sorted Array" << endl;
    sort(arr.begin(), arr.end(), cmp);
    for (int i : arr)
    {
        cout << i << " ";
    }
    cout << "\n";

    cout << "Frequency in Array" << endl;
    unordered_map<int, int> mp;
    for (int i; i < n; i++)
    {
        mp[arr[i]]++;
    }

    for (int i = 0; i < arr.size(); i++)
    {
        if (mp[arr[i]] > 0 && mp[2 * arr[i]] > 0)
        {
            mp[arr[i]]--;
            mp[2 * arr[i]]--;
        }
        else if (mp[arr[i]] > 0 && mp[2 * arr[i]] <= 0)
        {
            cout << "false";
            break;
        }
    }


    return 0;
}
