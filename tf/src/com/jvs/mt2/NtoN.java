package com.jvs.mt2;

public class NtoN {
	/*long counter(int n, int m) {
		if(m == 0)
			return 1;
		long sum = 0;
		for(int i=0; i<n; ++i) {
			sum  += counter(n, m-1);
		}
		System.out.println(sum);
		return sum;
	}*/
	static long c = 0;
	void counter(int n) {
		System.out.println(++c);
		for (int i = 0; i < n; ++i) {
			counter(n);
		}
	}
	public static void main(String[] args) {
		NtoN nn = new NtoN();
		nn.counter(5);
	}
}
