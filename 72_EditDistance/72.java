package com.zhang.Test;

public class Solution_72 {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();int m = word2.length();
        
        int[][] dp = new int[n+1][m+1];
        //把第一个字符串的前i个字符变为第二个字符串的前0个字符需要的步数
        for (int i=0; i<=n; i++)dp[i][0] = i;
        //把第一个字符串的前0个字符变为第二个字符串的前i个字符需要的步数
        for (int i=0; i<=m; i++)dp[0][i] = i;

        for (int i = 1; i <=n ; i++) {
            for (int j=1; j<=m; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;

                dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+(word1.charAt(i-1)!=word2.charAt(j-1)?1:0));

            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        Solution_72 solution_72 = new Solution_72();
        int res = solution_72.minDistance(s1,s2);
        System.out.println(res);
    }
}