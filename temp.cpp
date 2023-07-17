#include <bits/stdc++.h>
using namespace std;
 
vector<int> asteroidCollision(vector<int>& asteroids) {

  stack<int>a;

  for(int i=0;i<asteroids.size(); i++){
    if(asteroids[i]>0){
      a.push(i);
      continue;
    }

    while(!a.empty()){
      if(asteroids[a.top()]>abs(asteroids[i])){
        asteroids[i]=0;
        break;
      }
      else if(steroids[a.top()]==abs(asteroids[i])){
        asteroids[i]=0;
        a.top();
        asteroids[i]=0;
        break;
      }

      asteroids[a.top()]=0;
      a.pop();
    }

  }
  vector<int> ans;
     for(int i=0;i<asteroids.size();i++)
        if(asteroids[i]!=0)
            ans.push_back(asteroids[i]);

     return ans;
    
}

int main(){

  string exp = "(a+(b*c))+(d/e)";
  int n = exp.size();   
  printBracketNumber(exp, n);
  return 0;

}

