package com.erpbackend;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.erpbackend.production.MathTools;

public class MathToolsTest {
	
	@ParameterizedTest
	@ValueSource(ints = {0, 2, 4, 6, 8, 10, 100, 1000})
	void isEvenTest(int num) {
		Assertions.assertTrue(MathTools.isEven(num));
	}
	
	@Test
	@DisplayName("converting to double")
	void testconvertToDouble() {
		double result = MathTools.convertToDouble(4,2);
		assertEquals(2,result);
	}
	  @Test
	    void testConvertToDecimalInvalidDenominator() {
		  Assertions.assertThrows(IllegalArgumentException.class,()-> MathTools.convertToDouble(3, 0));
	  }

}
