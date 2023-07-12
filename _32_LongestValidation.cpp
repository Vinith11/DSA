#include<bits/stdc++.h>
#include <string>
using namespace std;

int main(){

  string str="";
  stack<int>stk;
  int count =0;
  int n=str.length();
  stk.push(-1);

  for(int i=0;i<n;i++){
    if(str[i]=='('){
      stk.push(i);
    }
    else{

    stk.pop();

      if(stk.empty()){
        stk.push(i);                        
      }
      else{
        count=max(count,i-stk.top());
      }
    }
  }
  cout<<count;

  return 0;  
}