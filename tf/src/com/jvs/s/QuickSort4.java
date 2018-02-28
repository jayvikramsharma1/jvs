package com.jvs.s;

public class QuickSort4 {
	public void sort(int[] arr) {
		qsort(arr, 0, arr.length-1);
	}
	public void qsort(int[] arr, int low, int high) {
		int i = low;
		int j = high;
		int pivot = arr[(low + (high-low)/2)];
		while(i<=j) {
			while(arr[i]<pivot)
				i++;
			while(arr[j] > pivot)
				j--;
			if(i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		if(low < j)
			qsort(arr, low, j);
		if(i < high)
			qsort(arr, i, high);
	}
	public static void main(String[] args) {
		QuickSort4 q4 = new QuickSort4();
		int arr[] = {2,5,1,6,3,88,33,55,1,0,2};
		q4.sort(arr);
		for(int i:arr) {
			System.out.print(i + " ");
		}
	}
}
