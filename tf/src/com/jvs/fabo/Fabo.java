package com.jvs.fabo;

public class Fabo {
	int fab(int n) {
		if(n <= 2)
			return 1;
		else
			return fab(n - 1) + fab(n - 2);
	}
	public static void main(String[] args) {
		Fabo f = new Fabo();
		System.out.println(f.fab(10));
	}
}
