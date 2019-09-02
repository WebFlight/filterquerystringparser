package nl.webflight.filterparser.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import nl.webflight.filterparser.interfaces.OperatorSetter;

class TestDecimalExpression {

	static DecimalExpression decimalExpression;
	static OperatorSetter operatorSetter;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		operatorSetter = Mockito.mock(OperatorSetter.class);
		decimalExpression = new DecimalExpression(operatorSetter);
	}

	@Test
	void testGetTextualValue() {
		String expectedTextualValue = "21.80";
		decimalExpression.setValue(expectedTextualValue);
		
		String actualValue = decimalExpression.getTextualValue();
		String expectedValue = String.valueOf(Double.valueOf(expectedTextualValue));
		
		assertEquals(expectedValue, actualValue);
	}

	@Test
	void testGetExpressionType() {
		ExpressionType expressionType = decimalExpression.getExpressionType();
		assertEquals(ExpressionType.DECIMAL, expressionType);
	}

	@Test
	void testGetValue() {
		String expectedTextualValue = "-14.380";
		decimalExpression.setValue(expectedTextualValue);
	
		double actualValue = decimalExpression.getValue();
		double expectedValue = Double.valueOf(expectedTextualValue);
		
		assertEquals(expectedValue, actualValue);
	}

}
