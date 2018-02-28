package com.jvs.s;

public class QuickSort3 {
	public void sort(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		qsort(arr, low, high);
	}
	public void qsort(int arr[], int low, int high) {
		int i = low;
		int j = high;
		int pivot = arr[(low + (high - low)/2)];
		while(i<=j) {
			while(arr[i] < pivot)
				i++;
			while(arr[j] > pivot)
				j--;
			if(i<=j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		if(low < j)
			qsort(arr, low, j);
		if(i<high)
			qsort(arr, i, high);
	}
	public static void main(String[] args) {
		QuickSort3 q3 = new QuickSort3();
		int[] arr = {3,56,22,77,33,99,44,88,21};
		q3.sort(arr);
		for(int i:arr){
			System.out.print(i + " ");
		}
	}
}
