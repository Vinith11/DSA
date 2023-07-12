#include<bits/stdc++.h>
#include <string>
using namespace std;

int dupParen(string str){
  stack<char>stk;
  
  int n=str.length();


  for(int i=0;i<n;i++){
    if(str[i]==')'){
      char top = stk.top();
      stk.pop();

      int count =0;
      while(top!='('){
        count++;
        top=stk.top();
        stk.pop();
      }
      if(count<1){
        return 1;                      
      }
    }
    else{
      stk.push(str[i]);      
    }
  }

  return 0;
}

int main(){

  string str="(((a+(b))+(c+d)))";
  
  if (dupParen(str))
        cout << "Duplicate Found ";
  else
        cout << "No Duplicates Found ";


  return 0;  
}