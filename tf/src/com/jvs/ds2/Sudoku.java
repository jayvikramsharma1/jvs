package com.jvs.ds2;

public class Sudoku {
	public static void main(String[] args) {
		int[][] grid = new int[][] 
		{
			{0,1,2,3},
			{4,5,6,7},
			{8,9,10,11},
			{12,13,14,15}
		};
		
		for(int i = 0; i<4; i++) {
			System.out.println(grid[i][0]);
		}
	}
}
