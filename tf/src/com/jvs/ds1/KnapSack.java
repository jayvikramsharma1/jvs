package com.jvs.ds1;

public class KnapSack {
	private static int knap(int[] wt, int[] val, int W) {
		if(W ==0 || val.length == 0 || wt.length == 0 || val == null | wt == null)
			return 0;
		int[][] k = new int[val.length + 1][W +1];
		
		for(int i = 0; i <= val.length; i++) {
			for(int w = 0; w <= W; w ++) {
				if(i==0 || w == 0)
					k[i][w] = 0;
				else if(wt[i - 1] <= w)
					k[i][w] = Math.max(val[i-1] + k[i-1][w-wt[i-1]], k[i-1][w]);
				else
					k[i][w] = k[i-1][w];
			}
		}
		return k[val.length][W];
	}
	public static void main(String[] args) {
		KnapSack kn = new KnapSack();
		int val[] = new int[]{60, 100, 120};
	    int wt[] = new int[]{10, 20, 30};
	    int  W = 50;
	    int n = val.length;
	    System.out.println(knap(wt, val, W));
	}
}
