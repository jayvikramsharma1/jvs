package com.jvs.s;

public class MergeSort {
	private int[] arry;
	private int[] tempArry;
	private int length;
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] input = {24,2,45,20,56,75,2,56,99,53,12};
		ms.sort(input);
		for(int i : input) {
			System.out.print(i + ", ");
		}
	}
	
	private void sort(int iarry[]) {
		this.arry = iarry;
		this.length = iarry.length;
		this.tempArry = new int[this.length];
		msort(0, length -1);
	}
	
	private void msort(int low, int high) {
		if(low < high) {
			int middle = low + (high-low) / 2;
			msort(low, middle);
			msort(middle + 1, high);
			msmerge(low, middle, high);
		}
	}
	
	private void msmerge(int low, int middle, int high) {
		for(int i = low; i<= high; i++)
			tempArry[i] = arry[i];
		int i = low;
		int j = middle + 1;
		int k = low;
		while(i <= middle && j <= high) {
			if(tempArry[i] <= tempArry[j]) {
				arry[k] = tempArry[i];
				i++;
			}
			else {
				arry[k] = tempArry[j];
				j++;
			}
			k++;
		}
		while(i <= middle) {
			arry[k] = tempArry[i];
			k++;
			i++;
		}
	}
}
