package com.erpbackend.production;

public class MathTools {
	
	public static boolean isEven(int n) {
		return n%2==0;
	}
	public static double convertToDouble(int numerator, int denominator) {
		
		if(denominator==0) {
			throw new IllegalArgumentException("should not be zero");
		}
		return (double)numerator/(double)denominator;
	}

}
