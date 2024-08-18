
public class _11_ContainWater {

    /*
     * Brute Force Approach
     * 
     * Steps:
     * 1. Initialize maxArea = 0
     * 2. Loop through the array
     * 3. Loop through the array from i+1
     * 4. Calculate the area by min of (height[i], height[j]) * (j-i)
     * 5. Update maxArea with Math.max(maxArea, currArea)
     * 6. Return maxArea
     * 
     * Time Complexity: O(n^2)
     */
    public static int method1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int currArea = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, currArea);
            }
        }
        return maxArea;
    }


    /*
     * Two Pointer Approach
     * 
     * Steps:
     * 1. Initialize l=0, r=height.length-1, maxArea=0
     * 2. Loop through the array until l<r
     * 3. Calculate the currArea by min of (height[l], height[r]) * (r-l)
     * 4. Update maxArea with Math.max(maxArea, currArea)
     * 5. If height[l] < height[r] then l++ since we need to maximize the area and we know one is already bigger one so we keep that one
     *       else r--
     * 6. Return maxArea
     * 
     * Time Complexity: O(n)
     */
    public static int method2(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;

        while (l < r) {
            int currArea = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(maxArea, currArea);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(method2(arr));
    }
}
