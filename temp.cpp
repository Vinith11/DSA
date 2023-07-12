#include<bits/stdc++.h>
#include <stack>
#include <string>
using namespace std;

int main(){

  string str="(((a+(b))+(c+d)))";
  
  stack<char>stack;
  stack.push('a');
  stack.push('b');
  stack.push('c');
   while (!stack.empty()) {
        cout << stack.top() <<" ";
        stack.pop();
    }


  return 0;  
}