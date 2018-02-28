package com.jvs.ds1;

public class KnapSack2 {
	private int calc(int[] val, int[] wt, int W) {
		if(val.length == 0 || val == null || wt.length == 0 || wt == null || W == 0)
			return 0;
		
		int n = val.length;
		int[][] K = new int[n + 1][W + 1];
		for(int i = 0; i <= n; i++)
			for(int w = 0; w<= W; w++) {
				if(i == 0 || w == 0)
					K[i][w] = 0;
				else if(wt[i-1] <= w)
					K[i][w] = Math.max(val[i-1] + K[i-1][w - wt[i-1]], K[i-1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		return K[n][W];
	}
	public static void main(String[] args) {
		
	}
}
