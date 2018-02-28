package com.jvs.s;

public class QuickSort2 {
	int arr[];
	
	private void sort(int in[]) {
		if(in == null || in.length == 0)
			return;
		arr = in;
		qsort(0, arr.length -1);
	}
	private void qsort(int low, int high) {
		int i = low;
		int j = high;
		int pivot = arr[low + (high - low) /2];
		
		while(i <= j) {
			while(arr[i] < pivot)
				i++;
			while(arr[j] > pivot)
				j--;
			if(i<= j) {
				swap(i, j);
				i ++;
				j --;
			}
			
		}
		if(low < j)
			qsort(low, j);
		if(i < high)
			qsort(i, high);
				
	}
	private void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void main(String[] args) {
		int[] in = {52,4,5645,2,454,2,4,456456,32,4,5,3244,5,6,4,4,3,43,45,3,34,53};
		QuickSort2 qs = new QuickSort2();
		qs.sort(in);
		for(int i : in)
			System.out.println(i + ", ");
	}
}
