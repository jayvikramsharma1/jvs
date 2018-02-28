package com.jvs.s;

public class QuickSort {
	private static int arry[];
	private int length;
	private void sort(int[] arr) {
		if(arr == null || arr.length == 0)
			return;
		this.arry = arr;
		length = arr.length;
		System.out.println(arry.length);
		qsort(0, length-1);
	}
	private void qsort(int low, int high) {
		int i = low;
		int j = high;
		int pivot = arry[low+ (high-low)/2];
		while(i <= j) {
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
		if(i < high)
			qsort(i, high);
	}
	private void swap(int i, int j) {
		System.out.println(i + "::::" + j);
		int temp = arry[i];
		arry[i] = arry[j];
		arry[j] = temp;
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] input = {24,2,45,20,56,75,2,56,99,53,12};
		qs.sort(input);
		for(int i: input) {
			System.out.print(i + ", ");
		}
	}
}
