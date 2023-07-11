#include<bits/stdc++.h>
using namespace std;



// This function finds the left smaller element for each element in the array `arr`.
// The result is stored in the array `SE`.
void lSmall(int arr[], int n, int SE[]) {
  // Create a stack to store the elements of the array.
  stack<int> S;

  for (int i = 0; i < n; i++) {
    // While the stack is not empty and the top element of the stack is greater than or equal to the current element,
    // pop the top element from the stack.
    while (!S.empty() && S.top() >= arr[i]) {
      S.pop();
    }

    // If the stack is not empty, store the top element of the stack in the `SE` array at index `i`.
    // Otherwise, store 0 in the `SE` array at index `i`.
    if (!S.empty()) {
      SE[i] = S.top();
    } else {
      SE[i] = 0;
    }

    // Push the current element into the stack.
    S.push(arr[i]);
  }
}

// This function finds the maximum difference between the left smaller element and the right smaller element of each element in the array `arr`.
// The result is returned.
int findMax(int arr[], int n) {
  // Create arrays to store the left smaller and right smaller elements of each element in the array.
  int LS[n], RS[n];

  // Find the left smaller elements of the array elements.
  lSmall(arr, n, LS);

  // Reverse the array.
  // Find the right smaller elements of the array elements.
  reverse(arr, arr + n);
  lSmall(arr, n, RS);

  // Initialize the maximum difference to -1.
  int result = -1;

  // Iterate over the array.
  // Find the absolute difference between the left smaller element and the right smaller element of the current element.
  // Update the maximum difference if the current difference is greater than the maximum difference so far.
  for (int i = 0; i < n; i++) {
    int diff = abs(LS[i] - RS[n - 1 - i]);
    result = max(result, diff);
  }

  return result;
}

int main() {

  int arr[] = {2, 4, 8, 7, 7, 9, 3};
  int n = sizeof(arr) / sizeof(arr[0]);
  int result = findMax(arr, n);

  cout << "Maximum diff : " << result << endl;

  return 0;
}