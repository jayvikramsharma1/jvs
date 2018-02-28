package com.jvs.ds1;

public class LongestPlaindromeSubSequence3 {
	
	private int calc(String str) {
		int len = str.length();
		int[][] dp = new int[len][len];
		
		for(int i=0; i< len; i ++)
			dp[i][i] = 1;
		for(int gap = 2; gap <= len; gap++)
			for(int i = 0; i<len-gap +1; i++) {
				int j = i + gap -1;
				if(str.charAt(i) == str.charAt(j)){
					if(gap ==2)
						dp[i][j] = 2;
					else
						dp[i][j] = Math.max(dp[i][j], 2+dp[i+1][j-1]);
				}
				else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		return dp[0][len -1];
	}
	
	public static void main(String[] args) {
		LongestPlaindromeSubSequence3 lsp = new LongestPlaindromeSubSequence3();
		System.out.println(lsp.calc("abba"));
	}
}
