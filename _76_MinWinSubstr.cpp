#include <bits/stdc++.h>
using namespace std;

string minWindow(string s, string t){
    if(s.size() < t.size()){
        return "";
    }
        

    unordered_map<char, int> tmap;
    for(int i=0; i<t.size(); i++){
        tmap[t[i]]++;
    }

    int count=0, start=0, min_length = INT_MAX, min_start = 0;
    for(int j=0; j<s.size(); j++){
        if(tmap[s[j]]>0){
            count++;
        }
        tmap[s[j]]--;
        if(count==t.length()){
            while (start < j && tmap[s[start]]<0)
            {
                tmap[s[start]]++, start++;
            }
            if(min_length > j-start){
                min_length = j - (min_start=start)+1;
            }
            tmap[s[start++]]++;
            count--;
        }
    }

    return min_length == INT_MAX ? "" : s.substr(min_start, min_length);
}

int main()
{
    string s = "ADOBECODEBANC";
    string t="ABC";
    cout<<minWindow(s, t);
    return 0;
}
