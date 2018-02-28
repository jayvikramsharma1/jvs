package com.jvs.s;

public class QuickSort1 {
	private int[] arry;
	private int len;
	
	private void sort(int[] in) {
		if(in == null || in.length ==0)
			return;
		this.arry = in;
		this.len = arry.length;
		qsort(0, len -1);
	}
	private void qsort(int low, int high){
		int i = low;
		int j = high;
		int pivot = arry[low + (high-low)/2];
		
		while(i<=j) {
			while(arry[i] < pivot)
				i++;
			while(arry[j] > pivot)
				j--;
			if(i<=j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		if(low < j)
			qsort(low, j);
		if(i< high)
			qsort(i, high);
			
	}
	private void swap(int i, int j) {
		int temp = arry[i];
		arry[i] = arry[j];
		arry[j] = temp;
	}
	public static void main(String[] args) {
		int[] input = {2,4,1,9,3,5,7,3,6};
		QuickSort1 qs = new QuickSort1();
		qs.sort(input);
		for(int i: input)
			System.out.print(i + ", ");
	}
}
