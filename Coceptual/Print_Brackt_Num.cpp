#include <bits/stdc++.h>
using namespace std;
 
void printBracketNumber(string exp, int n) {
  
  int left_bnum=1;
  stack<int>right_bnum;


  for (int i = 0; i < n; i++) {    
    if(exp[i]=='('){
      cout<< left_bnum<<" ";

      right_bnum.push(left_bnum);

      left_bnum++;
    }

    else if(exp[i]==')'){
      cout<<right_bnum.top()<<" ";

      right_bnum.pop();
    }
  }
}

int main(){

  string exp = "(a+(b*c))+(d/e)";
  int n = exp.size();   
  printBracketNumber(exp, n);
  return 0;

}

