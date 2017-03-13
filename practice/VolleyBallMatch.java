package com.practice2;

import java.math.BigInteger;
import java.util.Scanner;

public class VolleyBallMatch {

	static BigInteger tw = BigInteger.ONE;
	static BigInteger tl = BigInteger.ONE;
	static BigInteger num = BigInteger.ONE;
	static BigInteger den = BigInteger.ONE;
	static BigInteger v24 = BigInteger.ONE;
	
	
	static int volleyball(int A, int B){
		BigInteger mod = BigInteger.valueOf(1000000007);
		BigInteger selection = BigInteger.ZERO;
		if (A == 25 && B == 24) {
		} else if (A < 25 && B < 25) {
		} else if ((A == 25 && B < 24) || (B == 25 && A < 24)) {

			int c;
			if (A == 25) {
				tw = BigInteger.valueOf(A - 1 + B);
				tl = BigInteger.valueOf(B);
				c = B;
			} else {
				tw = BigInteger.valueOf(B - 1 + A);
				tl = BigInteger.valueOf(A);
				c = A;
			}

			for (int i = 1; i <= c; i++) {
				num = num.multiply(tw);
				tw = tw.subtract(BigInteger.ONE);
				den = den.multiply(tl);
				tl = tl.subtract(BigInteger.ONE);
			}
			selection = num.divide(den).mod(mod);

		} else if ((A - B == 2) || (B - A == 2)) {

			v24 = BigInteger.valueOf(801728689);
			num = v24;
			int c;
			if (A > B) {
				c = B - 24;
			} else {
				c = A - 24;
			}
			tw = BigInteger.valueOf(2);
			tw = tw.modPow(BigInteger.valueOf(c + 1), mod);
			selection = num.multiply(tw).mod(mod);

		}

		//System.out.println(way);
		
		return selection.intValue();
	}
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		volleyball(a, b);
	}

}
