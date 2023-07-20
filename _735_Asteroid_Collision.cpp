#include <bits/stdc++.h>
using namespace std;

vector<int> asteroidCollision(vector<int> &asteroids)
{

  stack<int> a;

  for (int i = 0; i < asteroids.size(); i++)
  {
    if (asteroids[i] > 0)
    {
      a.push(i);
      continue;
    }

    while (!a.empty())
    {
      if (asteroids[a.top()] > abs(asteroids[i]))
      {
        asteroids[i] = 0;
        break;
      }
      else if (asteroids[a.top()] == abs(asteroids[i]))
      {
        asteroids[i] = 0;
        a.top();
        asteroids[i] = 0;
        break;
      }

      asteroids[a.top()] = 0;
      a.pop();
    }
  }
  vector<int> ans;
  for (int i = 0; i < asteroids.size(); i++)
    if (asteroids[i] != 0)
      ans.push_back(asteroids[i]);

  return ans;
}

int main()
{

  vector<int>exp;
  exp.push_back(5);
  exp.push_back(10);
  exp.push_back(-5);
  asteroidCollision(exp);
  for(auto i:exp){
    cout<<i<<" ";
  }
  return 0;
}
