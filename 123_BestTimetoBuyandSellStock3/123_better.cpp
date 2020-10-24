class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int len = prices.size();
        if (len <2){
            return 0;
        }
        vector<int>dp(5,0);
        dp[1] = -prices[0];
        dp[3] = INT_MIN;
        for (int i = 1; i < len; ++i) {
            dp[0] = 0;
            dp[1] = max(dp[1],dp[0] - prices[i]);
            dp[2] = max(dp[2], dp[1] + prices[i]);
            dp[3] = max(dp[3] , dp[2] - prices[i]);
            dp[4] = max(dp[4], dp[3] + prices[i]);
        }
        return max(0, max(dp[2], dp[4]));
    }
};
