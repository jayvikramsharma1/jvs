package com.jvs.s;

public class QuickSort5 {
	public void sort(int arr[]){
		qsort(arr, 0, arr.length-1);
	}
	public void qsort(int arr[], int low, int high) {
		int i = low;
		int j = high;
		int pivot = arr[i];
		while(i <= j) {
			while(arr[i] < pivot)
				i++;
			while(arr[j] > pivot)
				j--;
			if(i<=j){
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
			
			
		}
		if(low <j)
			qsort(arr, low, j);
		if(i<high)
			qsort(arr, i, high);
	}
	public static void main(String[] args) {
		QuickSort5 q5 = new QuickSort5();
		int arr[] = {4,2,1,5,32,7,3,73,643,226,2};
		q5.sort(arr);
		for(int i : arr) {
			System.out.println(i + " ");
		}
	}
}
