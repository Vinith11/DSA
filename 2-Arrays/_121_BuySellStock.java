public class _121_BuySellStock{

    /*
     * Slding window approach
     * 
     * Steps:
     * 1. Initialize two pointers l and r to 0 and 1 respectively
     * 2. Iterate through the array
     * 3. If prices[l] < prices[r], calculate the current profit and update the maxProfit
     * 4. If prices[l] >= prices[r], update l to r
     * 5. Increment r
     * 6. Return maxProfit
     * 
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int method1(int[] prices){
        int l=0;
        int r=1;
        int maxProfit = 0;

        while(r<prices.length){
            if(prices[l]<prices[r]){
                int currentProfit = prices[r]-prices[l];
                maxProfit = Math.max(maxProfit, currentProfit);
            }else{
                l=r;
            }
            r++;
        }
        return maxProfit;
    }


    /*
     * Kadane's algorithm
     * 
     * Steps:
     * 1. Initialize buy to prices[0] and profit to 0
     * 2. Iterate through the array
     * 3. If prices[i] < buy, update buy to prices[i]
     * 4. If prices[i] - buy > profit, update profit to prices[i] - buy
     * 5. Return profit
     * 
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int method2(int[] prices){
        int buy = prices[0];
        int profit = 0;

        for(int i=1; i<prices.length; i++){
            if(prices[i]<buy){
                buy = prices[i];
            } else if(prices[i] - buy > profit){
                profit = prices[i] - buy;
            }
        }
        return profit;
    }

    


    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(temp2(prices));
    }

}