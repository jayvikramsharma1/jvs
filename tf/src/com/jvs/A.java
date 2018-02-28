package com.jvs;

public class A {
	public static void main(String[] args) {
		first f = new second();
		f = new third();
		System.out.println(f.test);
	}
}

class first {
	int test = 10;
	public int getTest() {
		return test;
	}
	
}

class second extends first {
	{
		super.test = 30;
	}
	int test = 20;
	public int getTest() {
		return test;
	}
}

class third extends second {
	
}