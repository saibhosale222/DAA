public class kna01 {

    public static void main(String[] args) {
        int val[] = {60, 100, 120};  // Values (profits)
        int weight[] = {10, 20, 30}; // Weights
        int W = 50;                  // Bag capacity
        
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                
                // If the weight of current item is less than or equal to the current capacity
                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        val[i - 1] + dp[i - 1][w - weight[i - 1]], // include item
                        dp[i - 1][w]                               // exclude item
                    );
                } else {
                    // If weight more than capacity, we cannot include this item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Final result is in dp[n][W]
        System.out.println("Maximum Profit in 0/1 Knapsack = " + dp[n][W]);
    }
}


