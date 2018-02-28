package com.jvs.ds1;

public class LongestPlaindromeSubSequence4 {
	private int calc(String str) {
		int len = str.length();
		int[][] dp = new int[len][len];
		
		for(int i = 0; i < len; i++)
			dp[i][i] = 1;
		for(int gap = 2; gap <= len; gap++)
			for(int i=0; i< len - gap + 1; i++) {
				int j = i + gap - 1;
				if(str.charAt(i) == str.charAt(j)) {
					if(gap == 2)
						dp[i][j] = 2;
					else
						dp[i][j] = Math.max(dp[i][j], 2+dp[i+1][j-1]);
				}
				else {
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		return dp[0][len - 1];
	}
	
	private int clacRecursive(String str, int start, int len) {
		if(len == 1)
			return 1;
		if(len == 0)
			return 0;
		if(str.charAt(start) == str.charAt(start + len -1)) 
			return 2+clacRecursive(str, start + 1, len - 2);
		else
			return Math.max(clacRecursive(str, start + 1, len -1), clacRecursive(str, start, len -1));
	}
	
	
	public static void main(String[] args) {
		LongestPlaindromeSubSequence4 lsp = new LongestPlaindromeSubSequence4();
		String str = "abddqcjdkfjdksfdsfkdsjfdjkjfjdskfdskfdsfkjkfdjkfdfdsfdkjfkdsjcqddba";
		System.out.println(lsp.clacRecursive(str, 0, str.length()) + " :::::::::::::::::::::: " + lsp.calc(str));
	}
}
 