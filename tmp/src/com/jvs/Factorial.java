package com.jvs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testSize = Integer.parseInt(br.readLine());
        if(testSize < 1)
            return;
        for(int i = 1; i < testSize; i++) {
            int N = Integer.parseInt(br.readLine());
            int fact = 1;
            if(N <= 2){
                System.out.println(N);
            }
            for(int j = N; j > 0; j--) {
                fact = fact * j;
            }
            System.out.println(fact);
        }
	}
}
